package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.qualitycontrol.QualityControlResultListDto;
import com.dev.thesisapi.dto.qualitycontrol.QualityControlTestResultDto;
import com.dev.thesisapi.dto.qualitycontrol.QualityTestResultInfoFromFrontendDto;
import com.dev.thesisapi.entity.*;
import com.dev.thesisapi.repository.QualityControlResultRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class QualityControlResultService {

    private final QualityControlResultRepository repository;
    private final OrderService orderService;
    private final SupplierService supplierService;
    private final OrderLineService orderLineService;
    private final QualityParameterService qualityParameterService;
    private final ProductService productService;
    private final StockService stockService;
    private final ProductSupplierService productSupplierService;
    private final SupplierOrderService supplierOrderService;

    private final SupplierRepository supplierRepository;

    public QualityControlResultService(QualityControlResultRepository repository, OrderService orderService,
                                       SupplierService supplierService, OrderLineService orderLineService,
                                       QualityParameterService qualityParameterService, ProductService productService,
                                       StockService stockService, ProductSupplierService productSupplierService,
                                       SupplierOrderService supplierOrderService, SupplierRepository supplierRepository) {
        this.repository = repository;
        this.orderService = orderService;
        this.supplierService = supplierService;
        this.orderLineService = orderLineService;
        this.qualityParameterService = qualityParameterService;
        this.productService = productService;
        this.stockService = stockService;
        this.productSupplierService = productSupplierService;
        this.supplierOrderService = supplierOrderService;
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 10000)
    public void create() {
        var orders = orderService.getAllOrders();

        orders.stream()
                .filter(order -> !repository.existsByOrderId(order.getId())) // Daha önce kayıt kontrolü
                .forEach(order -> {
                    var supplierName = supplierService.findById(order.getSupplier().getId()).getName();

                    // QualityControlResult oluştur ve kaydet
                    var qualityControlResult = new QualityControlResult();
                    qualityControlResult.setOrder(order);
                    qualityControlResult.setStatus(QualityControlStatus.PENDING);
                    repository.save(qualityControlResult);

                    // Order'a QualityControlResult'ı set et
                    order.setQualityControlResult(qualityControlResult);

                    System.out.println("QualityControlResult created for Order ID: " + order.getId() + " with Supplier: " + supplierName);
                });
    }


    public List<QualityControlResultListDto> getAll() {
        var qualityControlResults = repository.findAll();

        return qualityControlResults.stream().map(result -> {
            var order = result.getOrder();
            var supplierName = supplierService.findById(order.getSupplier().getId()).getName();

            return new QualityControlResultListDto()
                    .setOrderId(order.getId())
                    .setSupplierName(supplierName)
                    .setTestResult(result.getStatus());
        }).toList();
    }

    @Transactional
    public void saveResult(QualityTestResultInfoFromFrontendDto qualityTestResultInfoFromFrontendDto) {
        // 1. Fetch the order and its quality control result
        var order = orderService.getOrderById(qualityTestResultInfoFromFrontendDto.getOrderId());
        var qualityControlResult = order.getQualityControlResult();
        var supplierId = order.getSupplier().getId();

        // 2. Fetch the OrderLine for the product
        var orderLine = order.getOrderLineList().stream()
                .filter(line -> line.getProduct().getId().equals(qualityTestResultInfoFromFrontendDto.getProductId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("OrderLine not found: Product ID = "
                        + qualityTestResultInfoFromFrontendDto.getProductId()));

        var quantity = orderLine.getQuantity();

        // 3. Update the order status based on test results
        if (qualityTestResultInfoFromFrontendDto.getTestResult()) {
            qualityControlResult.setStatus(QualityControlStatus.APPROVED);
            order.setOrderStatus(OrderStatus.COMPLETED);

            // Handle stock updates
            handleStockUpdates(order, supplierId, orderLine, quantity);

            // Update supplier quality level and score for accepted results
            handleAcceptedResult(order.getSupplier());
        } else {
            qualityControlResult.setStatus(QualityControlStatus.REJECTED);
            order.setOrderStatus(OrderStatus.REFUSED);

            // Update supplier quality level and score for rejected results
            handleRejectedResult(order.getSupplier());
        }

        // 4. Create SupplierOrder for both approved and refused cases
        createSupplierOrder(order, orderLine, qualityTestResultInfoFromFrontendDto);

        // 5. Save QualityControlResult and Order
        repository.save(qualityControlResult);
        orderService.save(order);
    }

    private void createSupplierOrder(Order order, OrderLine orderLine, QualityTestResultInfoFromFrontendDto qualityTestResultInfoFromFrontendDto) {
        var orderStatus = order.getOrderStatus();
        var supplierOrder = new SupplierOrder();
        supplierOrder.setSupplier(order.getSupplier());
        supplierOrder.setProduct(orderLine.getProduct());
        supplierOrder.setQuantity(orderLine.getQuantity());

        Double totalTestRate = ((double) qualityTestResultInfoFromFrontendDto.getAcceptedSize() / qualityTestResultInfoFromFrontendDto.getSampleSize()) * 100;
        supplierOrder.setTotalTestRate(totalTestRate);
        supplierOrder.setCreatedAt(Instant.now());
        supplierOrder.setMinAcceptedSize(qualityTestResultInfoFromFrontendDto.getMinAcceptedSize());
        supplierOrder.setMaxRejectedSize(qualityTestResultInfoFromFrontendDto.getMaxRejectedSize());
        supplierOrder.setSampleSize(qualityTestResultInfoFromFrontendDto.getSampleSize());
        supplierOrder.setAcceptedSize(qualityTestResultInfoFromFrontendDto.getAcceptedSize());
        supplierOrder.setRejectedSize(qualityTestResultInfoFromFrontendDto.getRejectedSize());
        supplierOrder.setStatus(order.getOrderStatus());

        if (orderStatus.equals(OrderStatus.COMPLETED)) {
            supplierOrder.incrementTotalOrderAcceptedCount();
            supplierOrder.incrementTotalOrderCount();
        } else if (orderStatus.equals(OrderStatus.REFUSED)) {
            supplierOrder.incrementTotalOrderRejectedCount();
            supplierOrder.incrementTotalOrderCount();
        }
        // Save the SupplierOrder
        supplierOrderService.createSupplierOrder(supplierOrder);
    }

    private void handleStockUpdates(Order order, Integer supplierId, OrderLine orderLine, Integer quantity) {
        // Fetch or create ProductSupplier
        var productSupplier = productSupplierService.findFirstByProductIdAndSupplierId(orderLine.getProduct().getId(), supplierId);

        if (productSupplier == null) {
            productSupplier = new ProductSupplier();
            productSupplier.setProduct(orderLine.getProduct());
            productSupplier.setSupplier(order.getSupplier());
            productSupplierService.save(productSupplier);
        }

        // Handle stock updates
        var stock = stockService.getFirstStockByProductSupplier(productSupplier);
        if (stock != null) {
            stock.setQuantity(stock.getQuantity() + quantity);
            if (stock.getQuantity() > stock.getCriticalLevel()) {
                stock.setStatus(StockStatus.NORMAL);
            }
            stockService.save(stock);
        } else {
            var newStock = new Stock();
            newStock.setProductSupplier(productSupplier);
            newStock.setQuantity(quantity);
            newStock.setCriticalLevel(10);
            newStock.setStatus(newStock.getQuantity() > newStock.getCriticalLevel()
                    ? StockStatus.NORMAL : StockStatus.CRITICAL);
            newStock.setWarehouse(order.getWarehouse());
            newStock.setLastUpdated(Instant.now());
            stockService.save(newStock);
        }
    }

    // Onay Durumunu İşle
    private void handleAcceptedResult(Supplier supplier) {
        // Skor artırılır
        supplier.setScore(supplier.getScore() + 1);

        // Eğer skor 3'e ulaştıysa kalite seviyesi düşürülür ve skor sıfırlanır
        if (supplier.getScore() == 3) {
            adjustQualityLevel(supplier, false); // Kalite seviyesi düşürülür
            supplier.setScore(0); // Skor sıfırlanır
        }

        // Tedarikçi kaydedilir
        supplierRepository.save(supplier);
    }

    // Reddedilen Durumları İşle
    private void handleRejectedResult(Supplier supplier) {
        // Skor sıfırlanır
        supplier.setScore(0);

        // Kalite seviyesi artırılır
        adjustQualityLevel(supplier, true);

        // Tedarikçi kaydedilir
        supplierRepository.save(supplier);
    }

    // Kalite seviyesini artırır veya düşürür
    private void adjustQualityLevel(Supplier supplier, boolean increase) {
        Level currentLevel = supplier.getCurrentQualityLevel();
        Level newLevel;

        if (increase) {
            // Seviyeyi artır
            switch (currentLevel) {
                case LEVEL_1:
                    newLevel = Level.LEVEL_2;
                    break;
                case LEVEL_2:
                    newLevel = Level.LEVEL_3;
                    break;
                case LEVEL_3:
                    newLevel = Level.LEVEL_4;
                    break;
                default:
                    newLevel = Level.LEVEL_4; // Maksimum seviye
            }
        } else {
            // Seviyeyi düşür
            switch (currentLevel) {
                case LEVEL_4:
                    newLevel = Level.LEVEL_3;
                    break;
                case LEVEL_3:
                    newLevel = Level.LEVEL_2;
                    break;
                case LEVEL_2:
                    newLevel = Level.LEVEL_1;
                    break;
                default:
                    newLevel = Level.LEVEL_1; // Minimum seviye
            }
        }

        supplier.setCurrentQualityLevel(newLevel);
    }
}

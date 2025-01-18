package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.supplierorder.SupplierOrderFilteredResponseDto;
import com.dev.thesisapi.entity.OrderStatus;
import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.entity.SupplierOrder;
import com.dev.thesisapi.repository.SupplierOrderRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierOrderService {

    private final SupplierOrderRepository supplierOrderRepository;
    private final SupplierService supplierService;
    private final ProductService productService;

    public SupplierOrderService(SupplierOrderRepository supplierOrderRepository, SupplierService supplierService, ProductService productService) {
        this.supplierOrderRepository = supplierOrderRepository;
        this.supplierService = supplierService;
        this.productService = productService;
    }

    public List<SupplierOrderFilteredResponseDto> getSupplierOrdersBySupplierAndProduct(Integer supplierId, Integer productId) {

        Supplier supplier = supplierService.findById(supplierId);
        Product product = productService.getProductById(productId);
        var supplierOrder = supplierOrderRepository.findBySupplierOrderByCreatedAtDesc(supplier, product);
        return supplierOrder.stream().map(supplierOrder1 -> new SupplierOrderFilteredResponseDto()
                .setSupplierOrder(supplierOrder1)
                .setSupplierId(supplierId)
                .setSupplierName(supplier.getName())
                .setProductId(productId)
                .setProductName(product.getProductName())
                .setOrderId(supplierOrder1.getId()))
                .toList();
    }

    public void createSupplierOrder(SupplierOrder supplierOrder) {
        supplierOrderRepository.save(supplierOrder);
    }

    public List<SupplierOrderFilteredResponseDto> getAll() {
        var suppliers = supplierOrderRepository.findAll();
        return suppliers.stream().map(supplierOrder -> new SupplierOrderFilteredResponseDto()
                .setSupplierOrder(supplierOrder)
                .setSupplierId(supplierOrder.getSupplier().getId())
                .setSupplierName(supplierOrder.getSupplier().getName())
                .setProductId(supplierOrder.getProduct().getId())
                .setProductName(supplierOrder.getProduct().getProductName())
                .setOrderId(supplierOrder.getId()))
                .toList();
    }


    public Map<String, Object> generatePredictionInput(Integer supplierId, Integer productId) {
        // İlgili Supplier ve Product için siparişleri al
        List<SupplierOrder> supplierOrders = supplierOrderRepository.findBySupplierOrderByCreatedAtDesc(
                supplierService.findById(supplierId),
                productService.getProductById(productId)
        );

        // Verileri hesaplama
        int totalOrderCount = supplierOrders.size();
        int totalSuccessOrderCount = (int) supplierOrders.stream()
                .filter(order -> OrderStatus.COMPLETED.equals(order.getStatus()))
                .count();
        int sampleSize = supplierOrders.stream().mapToInt(SupplierOrder::getSampleSize).sum();
        int successSampleSize = supplierOrders.stream().mapToInt(SupplierOrder::getAcceptedSize).sum();

        // Son 3 siparişin durumu (1 = başarılı, 0 = başarısız)
        List<Integer> last3OrderStatus = supplierOrders.stream()
                .limit(3)
                .map(order -> OrderStatus.COMPLETED.equals(order.getStatus()) ? 1 : 0)
                .toList();

        // Girdi formatında döndürme
        Map<String, Object> input = new LinkedHashMap<>();
        input.put("total_order_count", totalOrderCount);
        input.put("total_success_order_count", totalSuccessOrderCount);
        input.put("sample_size", sampleSize);
        input.put("success_sample_size", successSampleSize);
        input.put("order_status_1", last3OrderStatus.size() > 0 ? last3OrderStatus.get(0) : 0);
        input.put("order_status_2", last3OrderStatus.size() > 1 ? last3OrderStatus.get(1) : 0);
        input.put("order_status_3", last3OrderStatus.size() > 2 ? last3OrderStatus.get(2) : 0);

        System.out.println(input);
        return input;
    }


    public List<SupplierOrder> getOrdersByProduct(Integer productId) {
        return supplierOrderRepository.findByProduct(productService.getProductById(productId).getId());
    }

    public List<SupplierOrder> getOrdersBySupplier(Integer supplierId) {
        return supplierOrderRepository.findBySupplier(supplierService.findById(supplierId).getId());
    }

}

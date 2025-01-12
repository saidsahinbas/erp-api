package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.qualitycontrol.QualityControlResultListDto;
import com.dev.thesisapi.dto.qualitycontrol.QualityControlTestResultDto;
import com.dev.thesisapi.entity.*;
import com.dev.thesisapi.repository.QualityControlResultRepository;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QualityControlResultService {

    private final QualityControlResultRepository repository;
    private final OrderService orderService;
    private final SupplierService supplierService;
    private final OrderLineService orderLineService;
    private final QualityParameterService qualityParameterService;
    private final ProductService productService;

    private final SupplierRepository supplierRepository;

    public QualityControlResultService(QualityControlResultRepository repository, OrderService orderService,
                                       SupplierService supplierService, OrderLineService orderLineService,
                                       QualityParameterService qualityParameterService, ProductService productService, SupplierRepository supplierRepository) {
        this.repository = repository;
        this.orderService = orderService;
        this.supplierService = supplierService;
        this.orderLineService = orderLineService;
        this.qualityParameterService = qualityParameterService;
        this.productService = productService;
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

        System.out.println("Quality control results created");
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

}

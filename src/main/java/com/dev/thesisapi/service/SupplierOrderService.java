package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.supplierorder.SupplierOrderFilteredResponseDto;
import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.entity.SupplierOrder;
import com.dev.thesisapi.repository.SupplierOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}

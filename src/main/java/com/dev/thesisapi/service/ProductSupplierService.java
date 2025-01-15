package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductSupplierService {
    private final ProductSupplierRepository productSupplierRepository;
    private final SupplierService supplierService;
    public ProductSupplierService(ProductSupplierRepository productSupplierRepository, SupplierService supplierService) {
        this.productSupplierRepository = productSupplierRepository;
        this.supplierService = supplierService;
    }

    public ProductSupplier create(ProductSupplier productSupplier) {
        return productSupplierRepository.save(productSupplier);
    }

    public List<Supplier> getAllProductSuppliers(Integer productId) {
        var listSuppliers = new ArrayList<Supplier>();
        var productSupplierList =  productSupplierRepository.findAllByProductId(productId);
        for (var productSupplier : productSupplierList) {
            var productSupplerTemp = productSupplierRepository.findById(productSupplier.getId()).orElse(null);

            Supplier supplier = supplierService.findById(productSupplier.getSupplier().getId());
            listSuppliers.add(supplier);
        }
        return listSuppliers;
    }

    public ProductSupplier findFirstByProductIdAndSupplierId(Integer productId, Integer supplierId) {
        return productSupplierRepository.findFirstByProductIdAndSupplierId(productId, supplierId);
    }

    public void save(ProductSupplier productSupplier) {
        productSupplierRepository.save(productSupplier);
    }
}

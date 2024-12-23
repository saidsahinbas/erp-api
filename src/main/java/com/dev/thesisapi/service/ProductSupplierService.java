package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.ProductSupplierRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductSupplierService {
    private final ProductSupplierRepository productSupplierRepository;

    public ProductSupplierService(ProductSupplierRepository productSupplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
    }

    public void create(ProductSupplier productSupplier) {
        productSupplierRepository.save(productSupplier);
    }

}

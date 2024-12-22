package com.dev.thesisapi.service;

import com.dev.thesisapi.repository.ProductSupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductSupplierService {
    private final ProductSupplierRepository productSupplierRepository;

    public ProductSupplierService(ProductSupplierRepository productSupplierRepository) {
        this.productSupplierRepository = productSupplierRepository;
    }
}

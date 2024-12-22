package com.dev.thesisapi.service;

import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    private final SupplierService supplierService;

    public SupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
}

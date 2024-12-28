package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Integer supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }
}

package com.dev.thesisapi.controller.supplier;

import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.service.SupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("all")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSupplier(
            @RequestPart("supplier") String supplierJson,
            @RequestPart(value = "document0", required = false) MultipartFile[] documents
    ) {
        try {
            // Parse the supplier JSON
            ObjectMapper objectMapper = new ObjectMapper();
            Supplier supplier = objectMapper.readValue(supplierJson, Supplier.class);

            // Pass the supplier and documents to the service
            supplierService.createSupplier(supplier, documents);

            return ResponseEntity.ok("Supplier created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error creating supplier: " + e.getMessage());
        }
    }
}

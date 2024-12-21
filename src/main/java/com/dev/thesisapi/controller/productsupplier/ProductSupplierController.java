package com.dev.thesisapi.controller.productsupplier;

import com.dev.thesisapi.service.ProductSupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/supplier")
public class ProductSupplierController {
    private final ProductSupplierService productSupplierService;

    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }
}

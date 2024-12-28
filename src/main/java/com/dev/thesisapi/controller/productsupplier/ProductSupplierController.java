package com.dev.thesisapi.controller.productsupplier;

import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.service.ProductSupplierService;
import com.dev.thesisapi.service.SupplierService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/supplier")
public class ProductSupplierController {
    private final ProductSupplierService productSupplierService;

    public ProductSupplierController(ProductSupplierService productSupplierService) {
        this.productSupplierService = productSupplierService;
    }

    @GetMapping("/product-suppliers/{productId}")
    public List<Supplier> getAllSuppliersByProductId(@PathVariable("productId") Integer productId) {
        return productSupplierService.getAllProductSuppliers(productId);
    }
}

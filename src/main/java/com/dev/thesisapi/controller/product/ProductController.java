package com.dev.thesisapi.controller.product;

import com.dev.thesisapi.dto.product.ProductCreateDto;
import com.dev.thesisapi.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("create")
    public void create(@RequestBody ProductCreateDto productCreateDto) {
        productService.create(productCreateDto);
    }
}

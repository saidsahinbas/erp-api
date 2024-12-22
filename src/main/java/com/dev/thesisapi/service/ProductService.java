package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.product.ProductCreateDto;
import com.dev.thesisapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(ProductCreateDto productCreateDto) {

    }
}

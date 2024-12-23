package com.dev.thesisapi.controller.product;

import com.dev.thesisapi.dto.product.GetAllProductResponseDto;
import com.dev.thesisapi.dto.product.GetSingleProductDetailDto;
import com.dev.thesisapi.dto.product.ProductCreateDto;
import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("all")
    public List<GetAllProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("create")
    public void create(@RequestBody ProductCreateDto productCreateDto) {
        productService.create(productCreateDto);
    }

    @GetMapping("{id}")
    public GetSingleProductDetailDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }
}

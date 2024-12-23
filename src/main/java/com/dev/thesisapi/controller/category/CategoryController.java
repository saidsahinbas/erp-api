package com.dev.thesisapi.controller.category;

import com.dev.thesisapi.entity.Category;
import com.dev.thesisapi.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}

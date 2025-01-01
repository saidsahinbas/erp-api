package com.dev.thesisapi.controller.category;

import com.dev.thesisapi.dto.UpdateCategoryDto;
import com.dev.thesisapi.entity.Category;
import com.dev.thesisapi.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("create")
    public void createCategory(@RequestBody String categoryName) {
        categoryService.createCategory(categoryName);
    }

    @GetMapping("all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PutMapping("update")
    public void updateCategory(@RequestBody UpdateCategoryDto category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("delete")
    public void deleteCategory(@RequestParam("categoryId") Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}

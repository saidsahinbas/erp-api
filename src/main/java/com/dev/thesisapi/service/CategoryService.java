package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.UpdateCategoryDto;
import com.dev.thesisapi.entity.Category;
import com.dev.thesisapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void createCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        categoryRepository.save(category);
    }

    public void updateCategory(UpdateCategoryDto category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: " + category.getId()));
        existingCategory.setCategoryName(category.getCategoryName()); // categoryName güncelleniyor mu?
        categoryRepository.save(existingCategory); // Veritabanına kaydediliyor mu?
    }


    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

package com.dev.thesisapi.dto;

public class UpdateCategoryDto {
    private Integer id;
    private String categoryName;

    public UpdateCategoryDto() {
    }

    public UpdateCategoryDto(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public UpdateCategoryDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public UpdateCategoryDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}

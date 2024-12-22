package com.dev.thesisapi.dto.product;

import java.math.BigDecimal;
import java.util.List;

public class ProductCreateDto {

    private String name;
    private String code;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String description;
    private Integer categoryId;
    private Integer supplierId;
    private String image1;
    private String image2;

    public ProductCreateDto() {
    }

    public ProductCreateDto(String name, String code, BigDecimal purchasePrice, BigDecimal salePrice, String description, Integer categoryId, Integer supplierIds, String image1, String image2) {
        this.name = name;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.description = description;
        this.categoryId = categoryId;
        this.supplierId = supplierIds;
        this.image1 = image1;
        this.image2 = image2;
    }

    public String getName() {
        return name;
    }

    public ProductCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ProductCreateDto setCode(String code) {
        this.code = code;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductCreateDto setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public ProductCreateDto setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public ProductCreateDto setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public ProductCreateDto setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public String getImage1() {
        return image1;
    }

    public ProductCreateDto setImage1(String image1) {
        this.image1 = image1;
        return this;
    }

    public String getImage2() {
        return image2;
    }

    public ProductCreateDto setImage2(String image2) {
        this.image2 = image2;
        return this;
    }
}

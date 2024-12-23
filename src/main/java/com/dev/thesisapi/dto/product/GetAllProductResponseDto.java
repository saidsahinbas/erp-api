package com.dev.thesisapi.dto.product;

import java.math.BigDecimal;
import java.util.Set;

public class GetAllProductResponseDto {
    private Integer id;
    private String productName;
    private String code;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String description;
    private String categoryName; // Map from Category
    private Set<String> productStatuses; // Map from ProductStatus enum
    private Set<String> supplierNames;

    public GetAllProductResponseDto() {
    }

    public GetAllProductResponseDto(Integer id, String productName, String code, BigDecimal purchasePrice,
                                    BigDecimal salePrice, String description, String categoryName, Set<String> productStatuses, Set<String> supplierNames) {
        this.id = id;
        this.productName = productName;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.description = description;
        this.categoryName = categoryName;
        this.productStatuses = productStatuses;
        this.supplierNames = supplierNames;
    }

    public Integer getId() {
        return id;
    }

    public GetAllProductResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public GetAllProductResponseDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GetAllProductResponseDto setCode(String code) {
        this.code = code;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public GetAllProductResponseDto setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public GetAllProductResponseDto setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GetAllProductResponseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public GetAllProductResponseDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Set<String> getProductStatuses() {
        return productStatuses;
    }

    public GetAllProductResponseDto setProductStatuses(Set<String> productStatuses) {
        this.productStatuses = productStatuses;
        return this;
    }

    public Set<String> getSupplierNames() {
        return supplierNames;
    }

    public GetAllProductResponseDto setSupplierNames(Set<String> supplierNames) {
        this.supplierNames = supplierNames;
        return this;
    }
}

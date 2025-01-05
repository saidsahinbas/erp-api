package com.dev.thesisapi.dto.product;

import java.math.BigDecimal;
import java.util.List;

public class GetProductsBySupplierDto {

    private Integer supplierId;
    private String supplierName;
    private List<ProductListDto> products;


    public GetProductsBySupplierDto() {
    }

    public GetProductsBySupplierDto(Integer supplierId, String supplierName, List<ProductListDto> products) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.products = products;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public GetProductsBySupplierDto setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public GetProductsBySupplierDto setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public List<ProductListDto> getProducts() {
        return products;
    }

    public GetProductsBySupplierDto setProducts(List<ProductListDto> products) {
        this.products = products;
        return this;
    }

    public static class ProductListDto{
        private Integer productId;
        private String productName;
        private BigDecimal purchasePrice;
        private BigDecimal salePrice;
        private String categoryName;

        public ProductListDto() {
        }

        public ProductListDto(Integer productId, String productName, BigDecimal purchasePrice, BigDecimal salePrice,
                              String categoryName) {
            this.productId = productId;
            this.productName = productName;
            this.purchasePrice = purchasePrice;
            this.salePrice = salePrice;
            this.categoryName = categoryName;
        }

        public Integer getProductId() {
            return productId;
        }

        public ProductListDto setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public String getProductName() {
            return productName;
        }

        public ProductListDto setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public BigDecimal getPurchasePrice() {
            return purchasePrice;
        }

        public ProductListDto setPurchasePrice(BigDecimal purchasePrice) {
            this.purchasePrice = purchasePrice;
            return this;
        }

        public BigDecimal getSalePrice() {
            return salePrice;
        }

        public ProductListDto setSalePrice(BigDecimal salePrice) {
            this.salePrice = salePrice;
            return this;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public ProductListDto setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }
    }
}

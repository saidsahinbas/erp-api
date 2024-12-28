package com.dev.thesisapi.dto.stock;

import com.dev.thesisapi.entity.Warehouse;

import java.math.BigDecimal;
import java.util.List;


public class CreateStockRequestDto {
    private Integer billNumber;
    private Warehouse warehouse;
    private List<ProductDetailDto> productDetails;

    public CreateStockRequestDto() {
    }

    public CreateStockRequestDto(Integer billNumber, Warehouse warehouse) {
        this.billNumber = billNumber;
        this.warehouse = warehouse;
    }

    public Integer getBillNumber() {
        return billNumber;
    }

    public CreateStockRequestDto setBillNumber(Integer billNumber) {
        this.billNumber = billNumber;
        return this;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public CreateStockRequestDto setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public List<ProductDetailDto> getProductDetails() {
        return productDetails;
    }

    public CreateStockRequestDto setProductDetails(List<ProductDetailDto> productDetails) {
        this.productDetails = productDetails;
        return this;
    }

    public static class ProductDetailDto {
        private Integer productId;
        private Integer quantity;
        private Integer criticalLevel;
        private String supplierName;

        public ProductDetailDto() {
        }

        public ProductDetailDto(Integer productId, Integer quantity,
                                Integer criticalLevel, String supplierName) {
            this.productId = productId;
            this.quantity = quantity;
            this.criticalLevel = criticalLevel;
            this.supplierName = supplierName;
        }

        public Integer getProductId() {
            return productId;
        }

        public ProductDetailDto setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public ProductDetailDto setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Integer getCriticalLevel() {
            return criticalLevel;
        }

        public ProductDetailDto setCriticalLevel(Integer criticalLevel) {
            this.criticalLevel = criticalLevel;
            return this;
        }

        public String getSupplierName() {
            return supplierName;
        }

        public ProductDetailDto setSupplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }
    }
}


package com.dev.thesisapi.dto.stock;

import com.dev.thesisapi.entity.StockStatus;

public class GetAllStockResponseDto {
    private Integer id;
    private Integer billNumber;
    private String warehouseName;
    private String productName;
    private Integer quantity;
    private String supplierName;
    private StockStatus status;
    private String categoryName;

    public GetAllStockResponseDto() {
    }

    public GetAllStockResponseDto(Integer id, Integer billNumber, String warehouseName, String productName,
                                  Integer quantity, String supplierName, StockStatus status, String categoryName) {
        this.id = id;
        this.billNumber = billNumber;
        this.warehouseName = warehouseName;
        this.productName = productName;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.status = status;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public GetAllStockResponseDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getBillNumber() {
        return billNumber;
    }

    public GetAllStockResponseDto setBillNumber(Integer billNumber) {
        this.billNumber = billNumber;
        return this;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public GetAllStockResponseDto setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public GetAllStockResponseDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public GetAllStockResponseDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public GetAllStockResponseDto setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public StockStatus getStatus() {
        return status;
    }

    public GetAllStockResponseDto setStatus(StockStatus status) {
        this.status = status;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public GetAllStockResponseDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
}

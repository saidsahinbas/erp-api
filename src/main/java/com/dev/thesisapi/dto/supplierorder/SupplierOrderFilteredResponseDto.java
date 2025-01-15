package com.dev.thesisapi.dto.supplierorder;

import com.dev.thesisapi.entity.SupplierOrder;

public class SupplierOrderFilteredResponseDto {
    private SupplierOrder supplierOrder;
    private Integer supplierId;
    private String supplierName;
    private Integer productId;
    private String productName;
    private Integer orderId;


    public SupplierOrderFilteredResponseDto() {
    }

    public SupplierOrderFilteredResponseDto(SupplierOrder supplierOrder, Integer supplierId, String supplierName,
                                            Integer productId, String productName, Integer orderId) {
        this.supplierOrder = supplierOrder;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productId = productId;
        this.productName = productName;
        this.orderId = orderId;
    }

    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
    }

    public SupplierOrderFilteredResponseDto setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
        return this;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public SupplierOrderFilteredResponseDto setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public SupplierOrderFilteredResponseDto setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public SupplierOrderFilteredResponseDto setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public SupplierOrderFilteredResponseDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public SupplierOrderFilteredResponseDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }
}

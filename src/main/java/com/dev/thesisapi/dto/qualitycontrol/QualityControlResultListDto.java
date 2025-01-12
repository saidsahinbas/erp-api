package com.dev.thesisapi.dto.qualitycontrol;

import com.dev.thesisapi.entity.QualityControlStatus;

public class QualityControlResultListDto {
    private Integer orderId;
    private String supplierName;
    private QualityControlStatus testResult;

    public QualityControlResultListDto() {
    }

    public QualityControlResultListDto(Integer orderId, String supplierName, QualityControlStatus testResult) {
        this.orderId = orderId;
        this.supplierName = supplierName;
        this.testResult = testResult;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public QualityControlResultListDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public QualityControlResultListDto setSupplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    public QualityControlStatus getTestResult() {
        return testResult;
    }

    public QualityControlResultListDto setTestResult(QualityControlStatus testResult) {
        this.testResult = testResult;
        return this;
    }
}

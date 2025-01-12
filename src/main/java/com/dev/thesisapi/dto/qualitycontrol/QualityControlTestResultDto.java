package com.dev.thesisapi.dto.qualitycontrol;

import com.dev.thesisapi.entity.QualityControlStatus;

public class QualityControlTestResultDto {
    private Integer orderId;
    private QualityControlStatus status;

    public QualityControlTestResultDto() {
    }

    public QualityControlTestResultDto(Integer orderId, QualityControlStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public QualityControlTestResultDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public QualityControlStatus getStatus() {
        return status;
    }

    public QualityControlTestResultDto setStatus(QualityControlStatus status) {
        this.status = status;
        return this;
    }
}

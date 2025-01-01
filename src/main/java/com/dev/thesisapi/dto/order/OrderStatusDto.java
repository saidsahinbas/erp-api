package com.dev.thesisapi.dto.order;

public class OrderStatusDto {
    private Integer orderId;
    private Integer userId;
    private Boolean status;

    public OrderStatusDto(Integer orderId, Integer userId, Boolean status) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
    }

    public OrderStatusDto() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderStatusDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderStatusDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public OrderStatusDto setStatus(Boolean status) {
        this.status = status;
        return this;
    }
}

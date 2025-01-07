package com.dev.thesisapi.dto.order;

import com.dev.thesisapi.entity.OrderStatus;

public class OrderStatusDto {
    private Integer orderId;
    private Integer userId;
    private OrderStatus status;


    public OrderStatusDto(Integer orderId, Integer userId, OrderStatus status) {
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

    public OrderStatus getStatus() {
        return status;
    }

    public OrderStatusDto setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }
}

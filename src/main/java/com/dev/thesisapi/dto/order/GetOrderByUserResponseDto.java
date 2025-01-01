package com.dev.thesisapi.dto.order;


import com.dev.thesisapi.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class GetOrderByUserResponseDto {
    private Integer orderId;
    private String orderTitle;
    private OrderStatus orderStatus;
    private String orderUser;
    private Instant orderDate;
    private BigDecimal price;

    public GetOrderByUserResponseDto() {
    }

    public GetOrderByUserResponseDto(Integer orderId, String orderTitle, OrderStatus orderStatus, String orderUser, Instant orderDate, BigDecimal price) {
        this.orderId = orderId;
        this.orderTitle = orderTitle;
        this.orderStatus = orderStatus;
        this.orderUser = orderUser;
        this.orderDate = orderDate;
        this.price = price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public GetOrderByUserResponseDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public GetOrderByUserResponseDto setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
        return this;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public GetOrderByUserResponseDto setOrderUser(String orderUser) {
        this.orderUser = orderUser;
        return this;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public GetOrderByUserResponseDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public GetOrderByUserResponseDto setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public GetOrderByUserResponseDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}

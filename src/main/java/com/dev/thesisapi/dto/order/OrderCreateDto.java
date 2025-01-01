package com.dev.thesisapi.dto.order;

import com.dev.thesisapi.entity.OrderStatus;
import com.dev.thesisapi.entity.OrderType;

import java.util.List;

public class OrderCreateDto {
    private OrderStatus orderStatus;
    private String description;
    private Integer supplierId;
    private List<OrderLineDto> orderLineDtoList;
    private String title;
    private Integer userId;
    private Integer warehouseId;
    private OrderType orderType;

    public OrderCreateDto(OrderType orderType, Integer warehouseId, Integer userId, String title, List<OrderLineDto> orderLineDtoList, Integer supplierId, OrderStatus orderStatus, String description) {
        this.orderType = orderType;
        this.warehouseId = warehouseId;
        this.userId = userId;
        this.title = title;
        this.orderLineDtoList = orderLineDtoList;
        this.supplierId = supplierId;
        this.orderStatus = orderStatus;
        this.description = description;
    }

    public OrderCreateDto() {
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public OrderCreateDto setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public OrderCreateDto setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public List<OrderLineDto> getOrderLineDtoList() {
        return orderLineDtoList;
    }

    public OrderCreateDto setOrderLineDtoList(List<OrderLineDto> orderLineDtoList) {
        this.orderLineDtoList = orderLineDtoList;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OrderCreateDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public OrderCreateDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public OrderCreateDto setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
        return this;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public OrderCreateDto setOrderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    public static class OrderLineDto {
        private Integer quantity;
        private Integer productId;

        public OrderLineDto() {
        }

        public OrderLineDto(Integer quantity, Integer productId) {
            this.quantity = quantity;
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public OrderLineDto setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Integer getProductId() {
            return productId;
        }

        public OrderLineDto setProductId(Integer productId) {
            this.productId = productId;
            return this;
        }
    }
}

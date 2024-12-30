package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.order.OrderCreateDto;
import com.dev.thesisapi.entity.Order;
import com.dev.thesisapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final SupplierService supplierService;
    private final WarehouseService warehouseService;


    public OrderService(OrderRepository orderRepository, UserService userService, SupplierService supplierService, WarehouseService warehouseService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.supplierService = supplierService;
        this.warehouseService = warehouseService;
    }

    public void create(OrderCreateDto orderCreateDto) {
        Order order = new Order();
        order.setOrderStatus(orderCreateDto.getOrderStatus());
        order.setOrderTitle(orderCreateDto.getTitle());
        order.setOrderType(orderCreateDto.getOrderType());
        order.setCreationDate(Instant.now());
        order.setDescription(orderCreateDto.getDescription());
        order.setUser(userService.getUser(orderCreateDto.getUserId()));
        order.setSupplier(supplierService.findById(orderCreateDto.getSupplierId()));
        order.setWarehouse(warehouseService.getWarehouse(orderCreateDto.getWarehouseId()));


    }
}

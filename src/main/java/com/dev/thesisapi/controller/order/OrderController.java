package com.dev.thesisapi.controller.order;

import com.dev.thesisapi.dto.order.OrderCreateDto;
import com.dev.thesisapi.dto.order.OrderStatusDto;
import com.dev.thesisapi.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public void createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        orderService.create(orderCreateDto);
    }

    @PostMapping("updateStatus")
    public void updateOrderStatus(@RequestBody OrderStatusDto orderStatusDto){
        orderService.purchaseApproval(orderStatusDto);
    }
}

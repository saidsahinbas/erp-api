package com.dev.thesisapi.controller.order;

import com.dev.thesisapi.dto.order.GetOrderByUserResponseDto;
import com.dev.thesisapi.dto.order.OrderCreateDto;
import com.dev.thesisapi.dto.order.OrderStatusDto;
import com.dev.thesisapi.entity.Order;
import com.dev.thesisapi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getOrderByUser/{id}")
    public List<GetOrderByUserResponseDto> getOrderByUser(@PathVariable Integer id){
        return orderService.getOrderByUser(id);
    }

    @GetMapping("getOrder/{id}")
    public Order getOrderById(@PathVariable Integer id ){
        return orderService.getOrderById(id);
    }

    @GetMapping("approvalOrder}")
    public List<GetOrderByUserResponseDto> getOrderByApproval(){
        return orderService.getOrderByApproval();
    }
}

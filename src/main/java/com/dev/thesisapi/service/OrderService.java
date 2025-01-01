package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.order.OrderCreateDto;
import com.dev.thesisapi.entity.Order;
import com.dev.thesisapi.entity.OrderLine;
import com.dev.thesisapi.entity.OrderType;
import com.dev.thesisapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final SupplierService supplierService;
    private final WarehouseService warehouseService;
    private final ProductService productService;
    private final OrderLineService orderLineService;


    public OrderService(OrderRepository orderRepository, UserService userService, SupplierService supplierService, WarehouseService warehouseService, ProductService productService, OrderLineService orderLineService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.supplierService = supplierService;
        this.warehouseService = warehouseService;
        this.productService = productService;
        this.orderLineService = orderLineService;
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
        var saveOrder = orderRepository.save(order);

        BigDecimal totalPrice = new BigDecimal(0);
        List<OrderLine> orderLineList = new ArrayList<>();
        for (var orderLine : orderCreateDto.getOrderLineDtoList()){
            OrderLine orderLineEntity = new OrderLine();
            orderLineEntity.setOrder(saveOrder);
            var product = productService.getProductById(orderLine.getProductId());
            orderLineEntity.setProduct(product);
            orderLineEntity.setQuantity(orderLine.getQuantity());
            if (orderCreateDto.getOrderType().equals(OrderType.PURCHASE)){
                totalPrice = totalPrice.add(product.getPurchasePrice().multiply(new BigDecimal(orderLine.getQuantity())));
            }else {
                totalPrice = totalPrice.add(product.getSalePrice().multiply(new BigDecimal(orderLine.getQuantity())));
            }
            var savedOrderLine = orderLineService.save(orderLineEntity);
            orderLineList.add(savedOrderLine);
        }

        saveOrder.setPrice(totalPrice);
        saveOrder.setOrderLineList(orderLineList);

        orderRepository.save(saveOrder);
    }
}

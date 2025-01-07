package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.order.GetOrderByUserResponseDto;
import com.dev.thesisapi.dto.order.OrderCreateDto;
import com.dev.thesisapi.dto.order.OrderStatusDto;
import com.dev.thesisapi.entity.*;
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
    private final PurchaseOrderApprovalService purchaseOrderApprovalService;


    public OrderService(OrderRepository orderRepository, UserService userService, SupplierService supplierService, WarehouseService warehouseService, ProductService productService, OrderLineService orderLineService, PurchaseOrderApprovalService purchaseOrderApprovalService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.supplierService = supplierService;
        this.warehouseService = warehouseService;
        this.productService = productService;
        this.orderLineService = orderLineService;
        this.purchaseOrderApprovalService = purchaseOrderApprovalService;
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

    public void purchaseApproval(OrderStatusDto orderStatusDto) {
        //order In statüsü değişecek ya onaylanacak ya da reddedilecek
        Order order = orderRepository.findById(orderStatusDto.getOrderId()).orElseThrow();
        var user = userService.getUser(orderStatusDto.getUserId());

        if (orderStatusDto.getStatus()){
            order.setOrderStatus(OrderStatus.APPROVED);
        }else {
            order.setOrderStatus(OrderStatus.REJECTED);
        }

        orderRepository.save(order);

        PurchaseOrderApproval purchaseOrderApproval = new PurchaseOrderApproval();
        purchaseOrderApproval.setOrder(order);
        purchaseOrderApproval.setUser(user);
        purchaseOrderApproval.setApprovedAt(Instant.now());
        purchaseOrderApprovalService.save(purchaseOrderApproval);

    }

    public List<GetOrderByUserResponseDto> getOrderByUser(Integer userId) {
        var user = userService.getUser(userId);
        var orderList = orderRepository.findAllByUser(user);
        List<GetOrderByUserResponseDto> getOrderByUserResponseDtoList = new ArrayList<>();
        for (var order : orderList) {
            GetOrderByUserResponseDto getOrderByUserResponseDto = new GetOrderByUserResponseDto();
            getOrderByUserResponseDto.setOrderId(order.getId());
            getOrderByUserResponseDto.setOrderStatus(order.getOrderStatus());
            getOrderByUserResponseDto.setOrderTitle(order.getOrderTitle());
            getOrderByUserResponseDto.setOrderDate(order.getCreationDate());
            getOrderByUserResponseDto.setPrice(order.getPrice());
            getOrderByUserResponseDto.setOrderUser(order.getUser().getFirstName() + " " + order.getUser().getLastName());
            getOrderByUserResponseDtoList.add(getOrderByUserResponseDto);
        }

        return getOrderByUserResponseDtoList;
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow();
    }


    public List<GetOrderByUserResponseDto> getOrderByApproval() {
        List<GetOrderByUserResponseDto> getOrderByUserResponseDtoList = new ArrayList<>();
        var orderList = orderRepository.findAllByOrders(); //Onay bekleyen siparişler
        for (var order : orderList) {
            GetOrderByUserResponseDto getOrderByUserResponseDto = new GetOrderByUserResponseDto();
            getOrderByUserResponseDto.setOrderId(order.getId());
            getOrderByUserResponseDto.setOrderStatus(order.getOrderStatus());
            getOrderByUserResponseDto.setOrderTitle(order.getOrderTitle());
            getOrderByUserResponseDto.setOrderDate(order.getCreationDate());
            getOrderByUserResponseDto.setPrice(order.getPrice());
            getOrderByUserResponseDto.setOrderUser(order.getUser().getFirstName() + " " + order.getUser().getLastName());
            getOrderByUserResponseDtoList.add(getOrderByUserResponseDto);
        }

        return getOrderByUserResponseDtoList;
    }
}

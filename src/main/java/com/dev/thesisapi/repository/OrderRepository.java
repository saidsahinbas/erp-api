package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Order;
import com.dev.thesisapi.entity.OrderStatus;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Order save(Order order);

    List<Order> findAllByUser(User user);

    List<Order> findAllByOrderStatus_Pending(OrderStatus orderStatus);
}

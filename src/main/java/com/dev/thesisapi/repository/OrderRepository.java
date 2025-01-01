package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Order;
import com.dev.thesisapi.repository.base.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Order save(Order order);
}

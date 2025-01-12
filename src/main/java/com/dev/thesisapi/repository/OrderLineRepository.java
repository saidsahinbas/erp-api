package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.OrderLine;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
    OrderLine save(OrderLine orderLine);

    List<OrderLine> findByOrderId(Integer orderId);
}

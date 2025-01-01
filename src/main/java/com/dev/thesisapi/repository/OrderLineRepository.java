package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.OrderLine;
import com.dev.thesisapi.repository.base.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
    OrderLine save(OrderLine orderLine);
}

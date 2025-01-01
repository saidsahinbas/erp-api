package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.OrderLine;
import com.dev.thesisapi.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    public OrderLine save(OrderLine orderLineEntity) {
        return orderLineRepository.save(orderLineEntity);
    }
}

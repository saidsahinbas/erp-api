package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Stock;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {
    List<Stock> findAll();
}

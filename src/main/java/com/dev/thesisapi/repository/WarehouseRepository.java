package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Warehouse;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {
    List<Warehouse> findAll();
}

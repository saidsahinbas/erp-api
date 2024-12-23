package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
    List<Supplier> findAll();
}

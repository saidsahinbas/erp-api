package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();

    Product save(Product product);
}

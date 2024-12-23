package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Category;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();
}

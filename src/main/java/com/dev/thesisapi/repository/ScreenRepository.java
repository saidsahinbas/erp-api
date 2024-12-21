package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface ScreenRepository extends CrudRepository<Screen, Integer> {
    List<Screen> findAll();
}

package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.QualityControlStandard;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface QualityControlStandartRepository extends CrudRepository<QualityControlStandard, Integer> {
    List<QualityControlStandard> findAll();
}

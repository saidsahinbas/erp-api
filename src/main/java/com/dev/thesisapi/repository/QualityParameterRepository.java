package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface QualityParameterRepository extends CrudRepository<QualityParameter, Integer> {
    QualityParameter save(QualityParameter entity);

    List<QualityParameter> findAll();
}

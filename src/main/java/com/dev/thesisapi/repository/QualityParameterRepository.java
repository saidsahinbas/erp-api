package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.repository.base.CrudRepository;

public interface QualityParameterRepository extends CrudRepository<QualityParameter, Integer> {
    QualityParameter save(QualityParameter entity);
}

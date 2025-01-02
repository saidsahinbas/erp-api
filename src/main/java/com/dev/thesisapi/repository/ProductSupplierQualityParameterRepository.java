package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.ProductSupplierQualityParameter;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface ProductSupplierQualityParameterRepository extends CrudRepository<ProductSupplierQualityParameter, Integer> {
    List<ProductSupplierQualityParameter> findByProductSupplierIdIn(List<Integer> productSupplierIds);

}

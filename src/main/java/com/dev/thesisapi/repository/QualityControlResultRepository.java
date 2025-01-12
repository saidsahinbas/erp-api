package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.QualityControlResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityControlResultRepository extends JpaRepository<QualityControlResult, Integer> {

    boolean existsByOrderId(Integer orderId);
}

package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Level;
import com.dev.thesisapi.entity.QualityControlLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QualityControlLevelRepository extends JpaRepository<QualityControlLevel, Integer> {
    @Query("SELECT qcl FROM QualityControlLevel qcl WHERE qcl.levelName = :supplierLevel AND" +
            " qcl.partAMin <= :quantity AND qcl.partAMax >= :quantity")
    QualityControlLevel findByLevelAndQuantity(@Param("supplierLevel") Level supplierLevel,
                                  @Param("quantity") Integer quantity);
}

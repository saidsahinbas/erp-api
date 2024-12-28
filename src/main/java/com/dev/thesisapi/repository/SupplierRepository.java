package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.base.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
    List<Supplier> findAll();

    @Query("SELECT s.id FROM Supplier s WHERE s.name = :name")
    Integer findSupplierIdByName(@Param("name") String name);

}

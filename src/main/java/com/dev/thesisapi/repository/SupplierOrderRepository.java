package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Product;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.entity.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer> {

    @Query("SELECT o FROM SupplierOrder o WHERE o.supplier = :supplier " +
            "AND o.product = :product ORDER BY o.createdAt ASC")
    List<SupplierOrder> findBySupplierOrderByCreatedAtDesc(Supplier supplier, Product product);

    @Query("SELECT o FROM SupplierOrder o WHERE o.supplier.id = :supplierId " +
            "AND o.product.id = :productId")
    SupplierOrder findBySupplierAndProduct(Integer supplierId, Integer productId);

    @Query("SELECT o FROM SupplierOrder o WHERE o.product.id = :productId")
    List<SupplierOrder> findByProduct(@Param("productId") Integer productId);

    @Query("SELECT o FROM SupplierOrder o WHERE o.supplier.id = :supplierId")
    List<SupplierOrder> findBySupplier(@Param("supplierId") Integer supplierId);

}

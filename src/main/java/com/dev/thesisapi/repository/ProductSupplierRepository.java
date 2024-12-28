package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.Supplier;
import com.dev.thesisapi.repository.base.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ProductSupplierRepository extends CrudRepository<ProductSupplier, Integer> {
    @Query("SELECT ps FROM ProductSupplier ps WHERE ps.product.id = :productId AND ps.supplier.id = :supplierId")
    ProductSupplier findByProductIdAndSupplierId(@Param("productId") Integer productId, @Param("supplierId") Integer supplierId);

    List<ProductSupplier> findAllSupplierIdsByProductId(Integer productId);

    List<ProductSupplier> findAllByProductId(Integer productId);

}

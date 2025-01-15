package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.ProductSupplier;
import com.dev.thesisapi.entity.Stock;
import com.dev.thesisapi.repository.base.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {
    List<Stock> findAll();

    @Query("SELECT s FROM Stock s WHERE " +
            "(:productName IS NULL OR s.productSupplier.product.productName = :productName) AND " +
            "(:productCode IS NULL OR s.productSupplier.product.code = :productCode) AND " +
            "(:categoryName IS NULL OR s.productSupplier.product.category.categoryName = :categoryName) AND " +
            "(:supplierName IS NULL OR s.productSupplier.supplier.name = :supplierName) AND " +
            "(:warehouseName IS NULL OR s.warehouse.name = :warehouseName)")
    List<Stock> findBYProductNameAndProductCodeAndCategoryNameAndSupplierNameAndWarehouseName(
            @Param("productName") String productName,
            @Param("productCode") String productCode,
            @Param("categoryName") String categoryName,
            @Param("supplierName") String supplierName,
            @Param("warehouseName") String warehouseName);


    Stock findFirstByProductSupplier(ProductSupplier productSupplier);
}

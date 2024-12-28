package com.dev.thesisapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private ProductSupplier productSupplier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Warehouse warehouse;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "critical_level", nullable = false)
    private Integer criticalLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StockStatus status;

    @Column(name = "last_updated")
    private Instant lastUpdated;

    public Stock() {
    }

    public Stock(Integer id, ProductSupplier productSupplier, Warehouse warehouse, Integer quantity,
                 Integer criticalLevel, StockStatus status, Instant lastUpdated) {
        this.id = id;
        this.productSupplier = productSupplier;
        this.warehouse = warehouse;
        this.quantity = quantity;
        this.criticalLevel = criticalLevel;
        this.status = status;
        this.lastUpdated = lastUpdated;
    }

    public Integer getId() {
        return id;
    }

    public Stock setId(Integer id) {
        this.id = id;
        return this;
    }

    public ProductSupplier getProductSupplier() {
        return productSupplier;
    }

    public Stock setProductSupplier(ProductSupplier productSupplier) {
        this.productSupplier = productSupplier;
        return this;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Stock setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Stock setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getCriticalLevel() {
        return criticalLevel;
    }

    public Stock setCriticalLevel(Integer criticalLevel) {
        this.criticalLevel = criticalLevel;
        return this;
    }

    public StockStatus getStatus() {
        return status;
    }

    public Stock setStatus(StockStatus status) {
        this.status = status;
        return this;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public Stock setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }
}
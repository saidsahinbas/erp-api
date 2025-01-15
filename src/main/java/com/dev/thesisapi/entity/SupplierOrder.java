package com.dev.thesisapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "supplier_order")
public class    SupplierOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @JsonIgnore
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    /*
    @Column(name = "sample_success_rate")
    private Double sampleSuccessRate;
    */
    @Column(name = "total_test_rate")
    private Double totalTestRate;

    @Column(name = "total_test_count")
    private Instant createdAt;

    @Column(name = "sample_size")
    private Integer sampleSize;

    @Column(name = "max_accepted_size")
    private Integer maxRejectedSize;

    @Column(name = "min_accepted_size")
    private Integer minAcceptedSize;

    @Column(name = "accepted_size")
    private Integer acceptedSize;

    @Column(name = "rejected_size")
    private Integer rejectedSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "total_order_count")
    private Integer totalOrderCount = 0;

    @Column(name = "total_order_accepted_count")
    private Integer totalOrderAcceptedCount = 0;

    @Column(name = "total_order_rejected_count")
    private Integer totalOrderRejectedCount = 0;

    public SupplierOrder() {
        this.createdAt = Instant.now();
    }

    public SupplierOrder(Supplier supplier, Product product, Integer quantity, Double totalTestRate,
                         Instant createdAt, Integer sampleSize, Integer maxRejectedSize,
                         Integer minAcceptedSize, Integer acceptedSize, Integer rejectedSize, OrderStatus status,
                         Integer totalOrderCount, Integer totalOrderAcceptedCount, Integer totalOrderRejectedCount) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
        this.totalTestRate = totalTestRate;
        this.createdAt = createdAt;
        this.sampleSize = sampleSize;
        this.maxRejectedSize = maxRejectedSize;
        this.minAcceptedSize = minAcceptedSize;
        this.acceptedSize = acceptedSize;
        this.rejectedSize = rejectedSize;
        this.status = status;
        this.totalOrderCount = totalOrderCount;
        this.totalOrderAcceptedCount = totalOrderAcceptedCount;
        this.totalOrderRejectedCount = totalOrderRejectedCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalTestRate() {
        return totalTestRate;
    }

    public void setTotalTestRate(Double totalTestRate) {
        this.totalTestRate = totalTestRate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Integer getMaxRejectedSize() {
        return maxRejectedSize;
    }

    public void setMaxRejectedSize(Integer maxRejectedSize) {
        this.maxRejectedSize = maxRejectedSize;
    }

    public Integer getMinAcceptedSize() {
        return minAcceptedSize;
    }

    public void setMinAcceptedSize(Integer minAcceptedSize) {
        this.minAcceptedSize = minAcceptedSize;
    }

    public Integer getAcceptedSize() {
        return acceptedSize;
    }

    public void setAcceptedSize(Integer acceptedSize) {
        this.acceptedSize = acceptedSize;
    }

    public Integer getRejectedSize() {
        return rejectedSize;
    }

    public void setRejectedSize(Integer rejectedSize) {
        this.rejectedSize = rejectedSize;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public Integer getTotalOrderAcceptedCount() {
        return totalOrderAcceptedCount;
    }

    public void setTotalOrderAcceptedCount(Integer totalOrderAcceptedCount) {
        this.totalOrderAcceptedCount = totalOrderAcceptedCount;
    }

    public Integer getTotalOrderRejectedCount() {
        return totalOrderRejectedCount;
    }

    public void setTotalOrderRejectedCount(Integer totalOrderRejectedCount) {
        this.totalOrderRejectedCount = totalOrderRejectedCount;
    }

    public void incrementTotalOrderCount() {
        this.totalOrderCount++;
    }

    public void incrementTotalOrderAcceptedCount() {
        this.totalOrderAcceptedCount++;
    }

    public void incrementTotalOrderRejectedCount() {
        this.totalOrderRejectedCount++;
    }

}

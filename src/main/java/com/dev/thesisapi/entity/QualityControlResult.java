package com.dev.thesisapi.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "quality_control_results")
public class QualityControlResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "qualityControlResult", fetch = FetchType.LAZY)
    private Order order;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QualityControlStatus status = QualityControlStatus.PENDING;


    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    public QualityControlResult() {}

    public QualityControlResult(Integer id, Order order, QualityControlStatus status, Instant createdAt,
                                Instant updatedAt) {
        this.id = id;
        this.order = order;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public QualityControlStatus getStatus() {
        return status;
    }

    public void setStatus(QualityControlStatus status) {
        this.status = status;
    }


    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}

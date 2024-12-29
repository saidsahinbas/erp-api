package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_supplier")
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_parameter_id", referencedColumnName = "id")
    private QualityParameter qualityParameter; // Ön tanımlı kalite parametresi

    @Column(name = "custom_value")
    private String customValue;

    public ProductSupplier() {
    }

    public ProductSupplier(Product product, Supplier supplier, QualityParameter qualityParameter, String customValue) {
        this.product = product;
        this.supplier = supplier;
        this.qualityParameter = qualityParameter;
        this.customValue = customValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public QualityParameter getQualityParameter() {
        return qualityParameter;
    }

    public void setQualityParameter(QualityParameter qualityParameter) {
        this.qualityParameter = qualityParameter;
    }

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String customValue) {
        this.customValue = customValue;
    }
}

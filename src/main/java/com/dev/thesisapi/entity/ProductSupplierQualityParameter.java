package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_supplier_quality_parameter")
public class ProductSupplierQualityParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_supplier_id", referencedColumnName = "id")
    private ProductSupplier productSupplier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_parameter_id", referencedColumnName = "id")
    private QualityParameter qualityParameter;

    @Column(name = "custom_value")
    private String customValue;

    public ProductSupplierQualityParameter() {
    }

    public ProductSupplierQualityParameter(ProductSupplier productSupplier, QualityParameter qualityParameter, String customValue) {
        this.productSupplier = productSupplier;
        this.qualityParameter = qualityParameter;
        this.customValue = customValue;
    }

    public ProductSupplier getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(ProductSupplier productSupplier) {
        this.productSupplier = productSupplier;
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

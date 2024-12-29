package com.dev.thesisapi.dto.product;

import com.dev.thesisapi.entity.ProductStatus;
import com.dev.thesisapi.entity.QualityParameter;
import com.dev.thesisapi.entity.ValueType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ProductCreateDto {

    private String name;
    private String code;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String description;
    private Integer categoryId;
    private List<Integer> supplierId;
    private String image1;
    private String image2;
    private Set<ProductStatus> productStatuses;
    private Set<QualityParameterDto> qualityParameterDtoSet;

    public ProductCreateDto() {
    }

    public ProductCreateDto(String name, String code, BigDecimal purchasePrice, BigDecimal salePrice, String description, Integer categoryId, List<Integer> supplierIds, String image1, String image2, Set<ProductStatus> productStatuses, Set<QualityParameterDto> qualityParameterDtoSet) {
        this.name = name;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.description = description;
        this.categoryId = categoryId;
        this.supplierId = supplierIds;
        this.image1 = image1;
        this.image2 = image2;
        this.productStatuses = productStatuses;
        this.qualityParameterDtoSet = qualityParameterDtoSet;
    }

    public String getName() {
        return name;
    }

    public ProductCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ProductCreateDto setCode(String code) {
        this.code = code;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductCreateDto setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public ProductCreateDto setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public ProductCreateDto setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public List<Integer> getSupplierId() {
        return supplierId;
    }

    public ProductCreateDto setSupplierId(List<Integer> supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public String getImage1() {
        return image1;
    }

    public ProductCreateDto setImage1(String image1) {
        this.image1 = image1;
        return this;
    }

    public String getImage2() {
        return image2;
    }

    public ProductCreateDto setImage2(String image2) {
        this.image2 = image2;
        return this;
    }

    public Set<ProductStatus> getProductStatuses() {
        return productStatuses;
    }

    public ProductCreateDto setProductStatuses(Set<ProductStatus> productStatuses) {
        this.productStatuses = productStatuses;
        return this;
    }

    public Set<QualityParameterDto> getQualityParameterDtoSet() {
        return qualityParameterDtoSet;
    }

    public ProductCreateDto setQualityParameterDtoSet(Set<QualityParameterDto> qualityParameterDtoSet) {
        this.qualityParameterDtoSet = qualityParameterDtoSet;
        return this;
    }

    public static class QualityParameterDto {
        private String name;
        private String description;
        private ValueType valueType;
        private String defaultValue;
        private String minValue;
        private String maxValue;
        private String customValue;

        public QualityParameterDto() {
        }

        public QualityParameterDto(String name, String maxValue, String minValue, ValueType valueType, String defaultValue, String description, String customValue) {
            this.name = name;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.valueType = valueType;
            this.defaultValue = defaultValue;
            this.description = description;
            this.customValue = customValue;
        }

        public String getMaxValue() {
            return maxValue;
        }

        public QualityParameterDto setMaxValue(String maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        public String getMinValue() {
            return minValue;
        }

        public QualityParameterDto setMinValue(String minValue) {
            this.minValue = minValue;
            return this;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public QualityParameterDto setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public ValueType getValueType() {
            return valueType;
        }

        public QualityParameterDto setValueType(ValueType valueType) {
            this.valueType = valueType;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public QualityParameterDto setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getName() {
            return name;
        }

        public QualityParameterDto setName(String name) {
            this.name = name;
            return this;
        }

        public String getCustomValue() {
            return customValue;
        }

        public QualityParameterDto setCustomValue(String customValue) {
            this.customValue = customValue;
            return this;
        }
    }

}

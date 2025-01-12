package com.dev.thesisapi.dto.qualitycontrol;

import com.dev.thesisapi.dto.qualityparameter.QualityParameterDto;
import com.dev.thesisapi.entity.Level;

import java.util.List;

public class SampleApproveAndRejectSizeByProductDto {
    private Integer productId;
    private String productName;
    private Integer sampleSize;
    private Integer approveSize;
    private Integer rejectSize;
    private Integer productQuantity;
    private Level supplierLevel;
    private List<QualityParameterDto> qualityParameters;

    public SampleApproveAndRejectSizeByProductDto() {
    }

    public SampleApproveAndRejectSizeByProductDto(Integer productId, String productName, Integer sampleSize,
                                                  Integer approveSize, Integer rejectSize, Integer productQuantity,
                                                  Level supplierLevel, List<QualityParameterDto> qualityParameters) {
        this.productId = productId;
        this.productName = productName;
        this.sampleSize = sampleSize;
        this.approveSize = approveSize;
        this.rejectSize = rejectSize;
        this.productQuantity = productQuantity;
        this.supplierLevel = supplierLevel;
    }

    public Integer getProductId() {
        return productId;
    }

    public SampleApproveAndRejectSizeByProductDto setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public SampleApproveAndRejectSizeByProductDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public SampleApproveAndRejectSizeByProductDto setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
        return this;
    }

    public Integer getApproveSize() {
        return approveSize;
    }

    public SampleApproveAndRejectSizeByProductDto setApproveSize(Integer approveSize) {
        this.approveSize = approveSize;
        return this;
    }

    public Integer getRejectSize() {
        return rejectSize;
    }

    public SampleApproveAndRejectSizeByProductDto setRejectSize(Integer rejectSize) {
        this.rejectSize = rejectSize;
        return this;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public SampleApproveAndRejectSizeByProductDto setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
        return this;
    }

    public Level getSupplierLevel() {
        return supplierLevel;
    }

    public SampleApproveAndRejectSizeByProductDto setSupplierLevel(Level supplierLevel) {
        this.supplierLevel = supplierLevel;
        return this;
    }

    public List<QualityParameterDto> getQualityParameters() {
        return qualityParameters;
    }

    public SampleApproveAndRejectSizeByProductDto setQualityParameters(List<QualityParameterDto> qualityParameters) {
        this.qualityParameters = qualityParameters;
        return this;
    }
}

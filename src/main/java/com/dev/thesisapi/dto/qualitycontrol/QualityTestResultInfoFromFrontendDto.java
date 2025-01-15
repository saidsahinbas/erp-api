package com.dev.thesisapi.dto.qualitycontrol;

public class QualityTestResultInfoFromFrontendDto {
    private Integer orderId;
    private Integer productId;
    private Boolean testResult;
    private Integer userId;
    private Integer sampleSize;
    private Integer maxRejectedSize;
    private Integer minAcceptedSize;
    private Integer acceptedSize;
    private Integer rejectedSize;

    public QualityTestResultInfoFromFrontendDto() {
    }

    public QualityTestResultInfoFromFrontendDto(Integer orderId, Boolean testResult,
                                                Integer productId, Integer userId, Integer sampleSize, Integer maxRejectedSize,
                                                Integer minAcceptedSize, Integer acceptedSize, Integer rejectedSize) {
        this.orderId = orderId;
        this.testResult = testResult;
        this.productId = productId;
        this.userId = userId;
        this.sampleSize = sampleSize;
        this.maxRejectedSize = maxRejectedSize;
        this.minAcceptedSize = minAcceptedSize;
        this.acceptedSize = acceptedSize;
        this.rejectedSize = rejectedSize;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public QualityTestResultInfoFromFrontendDto setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Boolean getTestResult() {
        return testResult;
    }

    public QualityTestResultInfoFromFrontendDto setTestResult(Boolean testResult) {
        this.testResult = testResult;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public QualityTestResultInfoFromFrontendDto setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public QualityTestResultInfoFromFrontendDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public QualityTestResultInfoFromFrontendDto setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
        return this;
    }

    public Integer getMaxRejectedSize() {
        return maxRejectedSize;
    }

    public QualityTestResultInfoFromFrontendDto setMaxRejectedSize(Integer maxRejectedSize) {
        this.maxRejectedSize = maxRejectedSize;
        return this;
    }

    public Integer getMinAcceptedSize() {
        return minAcceptedSize;
    }

    public QualityTestResultInfoFromFrontendDto setMinAcceptedSize(Integer minAcceptedSize) {
        this.minAcceptedSize = minAcceptedSize;
        return this;
    }

    public Integer getAcceptedSize() {
        return acceptedSize;
    }

    public QualityTestResultInfoFromFrontendDto setAcceptedSize(Integer acceptedSize) {
        this.acceptedSize = acceptedSize;
        return this;
    }

    public Integer getRejectedSize() {
        return rejectedSize;
    }

    public QualityTestResultInfoFromFrontendDto setRejectedSize(Integer rejectedSize) {
        this.rejectedSize = rejectedSize;
        return this;
    }
}

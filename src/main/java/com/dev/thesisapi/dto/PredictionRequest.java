package com.dev.thesisapi.dto;

public class PredictionRequest {
    private int totalOrderCount;
    private int totalSuccessOrderCount;
    private int sampleSize;
    private int successSampleSize;
    private int orderStatus1;
    private int orderStatus2;
    private int orderStatus3;

    public PredictionRequest() {
    }

    public PredictionRequest(int totalOrderCount, int totalSuccessOrderCount, int sampleSize, int successSampleSize, int orderStatus1, int orderStatus2, int orderStatus3) {
        this.totalOrderCount = totalOrderCount;
        this.totalSuccessOrderCount = totalSuccessOrderCount;
        this.sampleSize = sampleSize;
        this.successSampleSize = successSampleSize;
        this.orderStatus1 = orderStatus1;
        this.orderStatus2 = orderStatus2;
        this.orderStatus3 = orderStatus3;
    }

    public int getTotalOrderCount() {
        return totalOrderCount;
    }

    public PredictionRequest setTotalOrderCount(int totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
        return this;
    }

    public int getTotalSuccessOrderCount() {
        return totalSuccessOrderCount;
    }

    public PredictionRequest setTotalSuccessOrderCount(int totalSuccessOrderCount) {
        this.totalSuccessOrderCount = totalSuccessOrderCount;
        return this;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public PredictionRequest setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
        return this;
    }

    public int getSuccessSampleSize() {
        return successSampleSize;
    }

    public PredictionRequest setSuccessSampleSize(int successSampleSize) {
        this.successSampleSize = successSampleSize;
        return this;
    }

    public int getOrderStatus1() {
        return orderStatus1;
    }

    public PredictionRequest setOrderStatus1(int orderStatus1) {
        this.orderStatus1 = orderStatus1;
        return this;
    }

    public int getOrderStatus2() {
        return orderStatus2;
    }

    public PredictionRequest setOrderStatus2(int orderStatus2) {
        this.orderStatus2 = orderStatus2;
        return this;
    }

    public int getOrderStatus3() {
        return orderStatus3;
    }

    public PredictionRequest setOrderStatus3(int orderStatus3) {
        this.orderStatus3 = orderStatus3;
        return this;
    }
}

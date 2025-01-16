package com.dev.thesisapi.dto;

public class PredictionResponse {
    private String riskLabel;

    public PredictionResponse(String riskLabel) {
        this.riskLabel = riskLabel;
    }

    public String getRiskLabel() {
        return riskLabel;
    }

    public void setRiskLabel(String riskLabel) {
        this.riskLabel = riskLabel;
    }
}
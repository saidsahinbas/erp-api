package com.dev.thesisapi.dto.qualityparameter;

public class QualityParameterDto {
    private Integer id;
    private String name;
    private String description;
    private String defaultValue;
    private String minValue;
    private String maxValue;

    public QualityParameterDto() {
    }

    public QualityParameterDto(Integer id, String name, String description, String defaultValue,
                               String minValue, String maxValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Integer getId() {
        return id;
    }

    public QualityParameterDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public QualityParameterDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public QualityParameterDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public QualityParameterDto setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public String getMinValue() {
        return minValue;
    }

    public QualityParameterDto setMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public QualityParameterDto setMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
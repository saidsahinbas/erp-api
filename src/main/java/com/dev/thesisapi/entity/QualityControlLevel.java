package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quality_control_levels")
public class QualityControlLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "part_a_min", nullable = false)
    private Integer partAMin;

    @Column(name = "part_a_max", nullable = false)
    private Integer partAMax;

    @Column(name = "level_name", nullable = false)
    private Level levelName;

    @Column(name = "sample_size", nullable = false)
    private Integer sampleSize;

    @Column(name = "accepted_limit", nullable = false)
    private Integer acceptedLimit;

    @Column(name = "rejected_limit", nullable = false)
    private Integer rejectedLimit;

    public QualityControlLevel() {
    }

    public QualityControlLevel(Integer partAMin, Integer partAMax, Level levelName, Integer sampleSize,
                               Integer acceptedLimit, Integer rejectedLimit) {
        this.partAMin = partAMin;
        this.partAMax = partAMax;
        this.levelName = levelName;
        this.sampleSize = sampleSize;
        this.acceptedLimit = acceptedLimit;
        this.rejectedLimit = rejectedLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartAMin() {
        return partAMin;
    }

    public void setPartAMin(Integer partAMin) {
        this.partAMin = partAMin;
    }

    public Integer getPartAMax() {
        return partAMax;
    }

    public void setPartAMax(Integer partAMax) {
        this.partAMax = partAMax;
    }

    public Level getLevelName() {
        return levelName;
    }

    public void setLevelName(Level levelName) {
        this.levelName = levelName;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Integer getAcceptedLimit() {
        return acceptedLimit;
    }

    public void setAcceptedLimit(Integer acceptedLimit) {
        this.acceptedLimit = acceptedLimit;
    }

    public Integer getRejectedLimit() {
        return rejectedLimit;
    }

    public void setRejectedLimit(Integer rejectedLimit) {
        this.rejectedLimit = rejectedLimit;
    }
}

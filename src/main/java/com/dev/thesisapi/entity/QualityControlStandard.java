package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quality_control_standards")
public class QualityControlStandard {

    @Id
    private Integer id;

    @Column(name = "part_a_min")
    private Integer partAMin;

    @Column(name = "part_a_max")
    private Integer partAMax;

    @Column(name = "sample_size_level_1")
    private Integer sampleSizeLevel1;

    @Column(name = "accepted_level_1")
    private Integer acceptedLevel1;

    @Column(name = "rejected_level_1")
    private Integer rejectedLevel1;

    @Column(name = "sample_size_level_2")
    private Integer sampleSizeLevel2;

    @Column(name = "accepted_level_2")
    private Integer acceptedLevel2;

    @Column(name = "rejected_level_2")
    private Integer rejectedLevel2;

    @Column(name = "sample_size_level_3")
    private Integer sampleSizeLevel3;

    @Column(name = "accepted_level_3")
    private Integer acceptedLevel3;

    @Column(name = "rejected_level_3")
    private Integer rejectedLevel3;

    @Column(name = "sample_size_level_4")
    private Integer sampleSizeLevel4;

    @Column(name = "accepted_level_4")
    private Integer acceptedLevel4;

    @Column(name = "rejected_level_4")
    private Integer rejectedLevel4;

    public QualityControlStandard() {
    }

    public QualityControlStandard(Integer id, Integer partAMin, Integer partAMax, Integer sampleSizeLevel1,
                                  Integer acceptedLevel1, Integer rejectedLevel1, Integer sampleSizeLevel2,
                                  Integer acceptedLevel2, Integer rejectedLevel2, Integer sampleSizeLevel3,
                                  Integer acceptedLevel3, Integer rejectedLevel3, Integer sampleSizeLevel4,
                                  Integer acceptedLevel4, Integer rejectedLevel4) {
        this.id = id;
        this.partAMin = partAMin;
        this.partAMax = partAMax;
        this.sampleSizeLevel1 = sampleSizeLevel1;
        this.acceptedLevel1 = acceptedLevel1;
        this.rejectedLevel1 = rejectedLevel1;
        this.sampleSizeLevel2 = sampleSizeLevel2;
        this.acceptedLevel2 = acceptedLevel2;
        this.rejectedLevel2 = rejectedLevel2;
        this.sampleSizeLevel3 = sampleSizeLevel3;
        this.acceptedLevel3 = acceptedLevel3;
        this.rejectedLevel3 = rejectedLevel3;
        this.sampleSizeLevel4 = sampleSizeLevel4;
        this.acceptedLevel4 = acceptedLevel4;
        this.rejectedLevel4 = rejectedLevel4;
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

    public Integer getSampleSizeLevel1() {
        return sampleSizeLevel1;
    }

    public void setSampleSizeLevel1(Integer sampleSizeLevel1) {
        this.sampleSizeLevel1 = sampleSizeLevel1;
    }

    public Integer getAcceptedLevel1() {
        return acceptedLevel1;
    }

    public void setAcceptedLevel1(Integer acceptedLevel1) {
        this.acceptedLevel1 = acceptedLevel1;
    }

    public Integer getRejectedLevel1() {
        return rejectedLevel1;
    }

    public void setRejectedLevel1(Integer rejectedLevel1) {
        this.rejectedLevel1 = rejectedLevel1;
    }

    public Integer getSampleSizeLevel2() {
        return sampleSizeLevel2;
    }

    public void setSampleSizeLevel2(Integer sampleSizeLevel2) {
        this.sampleSizeLevel2 = sampleSizeLevel2;
    }

    public Integer getAcceptedLevel2() {
        return acceptedLevel2;
    }

    public void setAcceptedLevel2(Integer acceptedLevel2) {
        this.acceptedLevel2 = acceptedLevel2;
    }

    public Integer getRejectedLevel2() {
        return rejectedLevel2;
    }

    public void setRejectedLevel2(Integer rejectedLevel2) {
        this.rejectedLevel2 = rejectedLevel2;
    }

    public Integer getSampleSizeLevel3() {
        return sampleSizeLevel3;
    }

    public void setSampleSizeLevel3(Integer sampleSizeLevel3) {
        this.sampleSizeLevel3 = sampleSizeLevel3;
    }

    public Integer getAcceptedLevel3() {
        return acceptedLevel3;
    }

    public void setAcceptedLevel3(Integer acceptedLevel3) {
        this.acceptedLevel3 = acceptedLevel3;
    }

    public Integer getRejectedLevel3() {
        return rejectedLevel3;
    }

    public void setRejectedLevel3(Integer rejectedLevel3) {
        this.rejectedLevel3 = rejectedLevel3;
    }

    public Integer getSampleSizeLevel4() {
        return sampleSizeLevel4;
    }

    public void setSampleSizeLevel4(Integer sampleSizeLevel4) {
        this.sampleSizeLevel4 = sampleSizeLevel4;
    }

    public Integer getAcceptedLevel4() {
        return acceptedLevel4;
    }

    public void setAcceptedLevel4(Integer acceptedLevel4) {
        this.acceptedLevel4 = acceptedLevel4;
    }

    public Integer getRejectedLevel4() {
        return rejectedLevel4;
    }

    public void setRejectedLevel4(Integer rejectedLevel4) {
        this.rejectedLevel4 = rejectedLevel4;
    }
}
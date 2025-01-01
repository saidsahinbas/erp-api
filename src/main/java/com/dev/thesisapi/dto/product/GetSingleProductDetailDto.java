package com.dev.thesisapi.dto.product;

import com.dev.thesisapi.entity.Document;
import com.dev.thesisapi.entity.QualityParameter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class GetSingleProductDetailDto {
    private Integer id;
    private String productName;
    private String code;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private String description;
    private String categoryName; // Map from Category
    private Set<String> productStatuses; // Map from ProductStatus enum
    private Set<String> supplierNames;
    private String image1;
    private String image2;
    private List<Document> documentList;
    private List<QualityParameter> qualityParameterList;

    public GetSingleProductDetailDto() {
    }

    public GetSingleProductDetailDto(Integer id, String productName, String code, BigDecimal purchasePrice,
                                    BigDecimal salePrice, String description, String categoryName, Set<String> productStatuses,
                                     Set<String> supplierNames, String image1, String image2, List<Document> documentList, List<QualityParameter> qualityParameterList) {
        this.id = id;
        this.productName = productName;
        this.code = code;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.description = description;
        this.categoryName = categoryName;
        this.productStatuses = productStatuses;
        this.supplierNames = supplierNames;
        this.image1 = image1;
        this.image2 = image2;
        this.documentList = documentList;
        this.qualityParameterList = qualityParameterList;
    }

    public Integer getId() {
        return id;
    }

    public GetSingleProductDetailDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public GetSingleProductDetailDto setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public GetSingleProductDetailDto setCode(String code) {
        this.code = code;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public GetSingleProductDetailDto setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public GetSingleProductDetailDto setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GetSingleProductDetailDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public GetSingleProductDetailDto setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Set<String> getProductStatuses() {
        return productStatuses;
    }

    public GetSingleProductDetailDto setProductStatuses(Set<String> productStatuses) {
        this.productStatuses = productStatuses;
        return this;
    }

    public Set<String> getSupplierNames() {
        return supplierNames;
    }

    public GetSingleProductDetailDto setSupplierNames(Set<String> supplierNames) {
        this.supplierNames = supplierNames;
        return this;
    }

    public String getImage1() {
        return image1;
    }

    public GetSingleProductDetailDto setImage1(String image1) {
        this.image1 = image1;
        return this;
    }

    public String getImage2() {
        return image2;
    }

    public GetSingleProductDetailDto setImage2(String image2) {
        this.image2 = image2;
        return this;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public GetSingleProductDetailDto setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
        return this;
    }

    public List<QualityParameter> getQualityParameterList() {
        return qualityParameterList;
    }

    public GetSingleProductDetailDto setQualityParameterList(List<QualityParameter> qualityParameterList) {
        this.qualityParameterList = qualityParameterList;
        return this;
    }
}

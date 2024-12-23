package com.dev.thesisapi.entity;

import com.dev.thesisapi.entity.util.ProductStatusDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ProductStatusDeserializer.class)
public enum ProductStatus {
    SATISTA,
    TEDARIK_EDILIYOR,
    AKTIF,
    PASIF,
    ENVANTERE_DAHIL,
    URETILIYOR
}
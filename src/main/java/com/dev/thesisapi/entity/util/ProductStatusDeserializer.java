package com.dev.thesisapi.entity.util;

import com.dev.thesisapi.entity.ProductStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;

public class ProductStatusDeserializer extends JsonDeserializer<ProductStatus> {
    @Override
    public ProductStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase().replace(" ", "_");
        return ProductStatus.valueOf(value);
    }
}

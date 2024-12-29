package com.dev.thesisapi.entity.util;

import com.dev.thesisapi.entity.SupplierStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class SupplierStatusDeserializer extends JsonDeserializer<SupplierStatus> {
    @Override
    public SupplierStatus deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String value = jsonParser.getText().toUpperCase(); // Normalize the value to uppercase
        switch (value) {
            case "MUSTERI":
            case "MÜŞTERİ":
                return SupplierStatus.MUSTERI; // Map both to the correct enum
            case "AKTİF":
            case "AKTIF":
                return SupplierStatus.AKTIF;
            case "TEDARİKÇİ":
            case "TEDARIKCI":
                return SupplierStatus.TEDARIKCI;
            case "POTANSİYEL":
            case "POTANSIYEL":
                return SupplierStatus.POTANSIYEL;
            default:
                throw new IllegalArgumentException("Unknown SupplierStatus: " + value);
        }
    }
}

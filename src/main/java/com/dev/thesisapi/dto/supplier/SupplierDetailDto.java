package com.dev.thesisapi.dto.supplier;

import com.dev.thesisapi.entity.Level;
import com.dev.thesisapi.entity.SupplierStatus;

public class SupplierDetailDto {
    private SupplierStatus status;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Level level;

    public SupplierDetailDto() {
    }

    public SupplierDetailDto(SupplierStatus status, String name, String email, String phone, String address, Level level) {
        this.status = status;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.level = level;
    }

    public SupplierStatus getStatus() {
        return status;
    }

    public SupplierDetailDto setStatus(SupplierStatus status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public SupplierDetailDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SupplierDetailDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SupplierDetailDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SupplierDetailDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public SupplierDetailDto setLevel(Level level) {
        this.level = level;
        return this;
    }
}

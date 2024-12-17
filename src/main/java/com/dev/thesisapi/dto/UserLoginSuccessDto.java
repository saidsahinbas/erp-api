package com.dev.thesisapi.dto;

import com.google.gson.annotations.SerializedName;

public class UserLoginSuccessDto {
    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("authorityId")
    private Long authorityId;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("email")
    private String email;

    @SerializedName("status")
    private String status;

    public UserLoginSuccessDto() {
    }

    public UserLoginSuccessDto(String firstName, String lastName, Long authorityId, String password, String role, String email, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorityId = authorityId;
        this.password = password;
        this.role = role;
        this.email = email;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserLoginSuccessDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserLoginSuccessDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public UserLoginSuccessDto setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginSuccessDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserLoginSuccessDto setRole(String role) {
        this.role = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserLoginSuccessDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UserLoginSuccessDto setStatus(String status) {
        this.status = status;
        return this;
    }
}

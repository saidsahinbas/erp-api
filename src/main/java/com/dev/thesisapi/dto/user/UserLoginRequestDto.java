package com.dev.thesisapi.dto.user;

import com.google.gson.annotations.SerializedName;

public class UserLoginRequestDto {

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}

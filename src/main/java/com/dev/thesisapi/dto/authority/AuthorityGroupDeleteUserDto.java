package com.dev.thesisapi.dto.authority;

public class AuthorityGroupDeleteUserDto {
    private Integer id;
    private Integer userId;

    public AuthorityGroupDeleteUserDto() {
    }

    public AuthorityGroupDeleteUserDto(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public AuthorityGroupDeleteUserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public AuthorityGroupDeleteUserDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}

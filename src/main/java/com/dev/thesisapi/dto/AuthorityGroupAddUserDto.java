package com.dev.thesisapi.dto;

import java.util.List;

public class AuthorityGroupAddUserDto {
    private Integer id;
    private List<Integer> userIds;

    public AuthorityGroupAddUserDto() {
    }

    public AuthorityGroupAddUserDto(Integer id, List<Integer> userIds) {
        this.id = id;
        this.userIds = userIds;
    }

    public Integer getId() {
        return id;
    }

    public AuthorityGroupAddUserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public AuthorityGroupAddUserDto setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }
}

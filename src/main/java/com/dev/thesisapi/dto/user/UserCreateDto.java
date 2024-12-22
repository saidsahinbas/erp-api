package com.dev.thesisapi.dto.user;

public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer roleId;
    private Integer authorityGroupId;
    private String status;

    public UserCreateDto() {
    }

    public UserCreateDto(String firstName, String lastName, String email, String password, Integer roleId, Integer AuthorityGroupId, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.authorityGroupId = AuthorityGroupId;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserCreateDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserCreateDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserCreateDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserCreateDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public UserCreateDto setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getAuthorityGroupId() {
        return authorityGroupId;
    }

    public UserCreateDto setAuthorityGroupId(Integer authorityGroupId) {
        this.authorityGroupId = authorityGroupId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UserCreateDto setStatus(String status) {
        this.status = status;
        return this;
    }
}

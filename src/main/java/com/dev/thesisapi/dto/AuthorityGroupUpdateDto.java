package com.dev.thesisapi.dto;

import java.util.List;

public class AuthorityGroupUpdateDto {
    private Integer id;
    private String groupName;
    private List<RolePermissionItem> rolePermissionItems;

    public AuthorityGroupUpdateDto() {
    }

    public AuthorityGroupUpdateDto(Integer id, String groupName, List<RolePermissionItem> rolePermissionItems) {
        this.id = id;
        this.groupName = groupName;
        this.rolePermissionItems = rolePermissionItems;
    }

    public Integer getId() {
        return id;
    }

    public AuthorityGroupUpdateDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public AuthorityGroupUpdateDto setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public List<RolePermissionItem> getRolePermissionItems() {
        return rolePermissionItems;
    }

    public AuthorityGroupUpdateDto setRolePermissionItems(List<RolePermissionItem> rolePermissionItems) {
        this.rolePermissionItems = rolePermissionItems;
        return this;
    }

    public static class RolePermissionItem {
        private Integer screenId;
        private Boolean create;
        private Boolean delete;
        private Boolean read;
        private Boolean update;

        public RolePermissionItem() {
        }

        public RolePermissionItem(Integer screenId, Boolean delete, Boolean create, Boolean read, Boolean update) {
            this.screenId = screenId;
            this.delete = delete;
            this.create = create;
            this.read = read;
            this.update = update;
        }



        public Integer getScreenId() {
            return screenId;
        }

        public RolePermissionItem setScreenId(Integer screenId) {
            this.screenId = screenId;
            return this;
        }

        public Boolean getCreate() {
            return create;
        }

        public RolePermissionItem setCreate(Boolean create) {
            this.create = create;
            return this;
        }

        public Boolean getDelete() {
            return delete;
        }

        public RolePermissionItem setDelete(Boolean delete) {
            this.delete = delete;
            return this;
        }

        public Boolean getRead() {
            return read;
        }

        public RolePermissionItem setRead(Boolean read) {
            this.read = read;
            return this;
        }

        public Boolean getUpdate() {
            return update;
        }

        public RolePermissionItem setUpdate(Boolean update) {
            this.update = update;
            return this;
        }
    }

}

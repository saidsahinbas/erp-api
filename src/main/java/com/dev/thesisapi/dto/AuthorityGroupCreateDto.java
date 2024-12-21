package com.dev.thesisapi.dto;

import java.util.List;

public class AuthorityGroupCreateDto {
    private String groupName;
    private List<RolePermissionItem> rolePermissionItems;

    public AuthorityGroupCreateDto() {
    }

    public AuthorityGroupCreateDto(String groupName, List<RolePermissionItem> rolePermissionItems) {
        this.groupName = groupName;
        this.rolePermissionItems = rolePermissionItems;
    }

    public String getGroupName() {
        return groupName;
    }

    public AuthorityGroupCreateDto setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public List<RolePermissionItem> getRolePermissionItems() {
        return rolePermissionItems;
    }

    public AuthorityGroupCreateDto setRolePermissionItems(List<RolePermissionItem> rolePermissionItems) {
        this.rolePermissionItems = rolePermissionItems;
        return this;
    }

    public static class RolePermissionItem {
        private Integer screenId;
        private Boolean create;
        private Boolean delete;
        private Boolean read;
        private Boolean update;

        public RolePermissionItem(Integer screenId, Boolean create, Boolean delete, Boolean read, Boolean update) {
            this.screenId = screenId;
            this.create = create;
            this.delete = delete;
            this.read = read;
            this.update = update;
        }

        public RolePermissionItem() {
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

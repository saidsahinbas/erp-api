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

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<RolePermissionItem> getRolePermissionItems() {
        return rolePermissionItems;
    }

    public void setRolePermissionItems(List<RolePermissionItem> rolePermissionItems) {
        this.rolePermissionItems = rolePermissionItems;
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

        public void setScreenId(Integer screenId) {
            this.screenId = screenId;
        }

        public Boolean getCreate() {
            return create;
        }

        public void setCreate(Boolean create) {
            this.create = create;
        }

        public Boolean getDelete() {
            return delete;
        }

        public void setDelete(Boolean delete) {
            this.delete = delete;
        }

        public Boolean getRead() {
            return read;
        }

        public void setRead(Boolean read) {
            this.read = read;
        }

        public Boolean getUpdate() {
            return update;
        }

        public void setUpdate(Boolean update) {
            this.update = update;
        }
    }

}

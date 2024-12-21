package com.dev.thesisapi.dto;

import java.util.List;

public class AuthorityGroupUpdateDto {
    private Integer id;
    private String groupName;
    private List<RolePermissionItem> rolePermissionItems;
    private List<Integer> userItemList;

    public AuthorityGroupUpdateDto() {
    }

    public AuthorityGroupUpdateDto(Integer id, String groupName, List<RolePermissionItem> rolePermissionItems, List<Integer> userItemList) {
        this.id = id;
        this.groupName = groupName;
        this.rolePermissionItems = rolePermissionItems;
        this.userItemList = userItemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Integer> getUserItemList() {
        return userItemList;
    }

    public void setUserItemList(List<Integer> userItemList) {
        this.userItemList = userItemList;
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

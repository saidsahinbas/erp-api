package com.dev.thesisapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "authority_id", referencedColumnName = "id")
    private AuthorityGroup authorityGroup;

    @ManyToOne
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    private Screen screen;

    @Column(name = "read")
    private Boolean read;

    @Column(name = "update")
    private Boolean update;

    @Column(name = "create")
    private Boolean create;

    @Column(name = "delete")
    private Boolean delete;

    public RolePermission() {
    }

    public RolePermission(Integer id, AuthorityGroup authorityGroup, Screen screen, Boolean read, Boolean update, Boolean create, Boolean delete) {
        this.id = id;
        this.authorityGroup = authorityGroup;
        this.screen = screen;
        this.read = read;
        this.update = update;
        this.create = create;
        this.delete = delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorityGroup getAuthorityGroup() {
        return authorityGroup;
    }

    public void setAuthorityGroup(AuthorityGroup authorityGroup) {
        this.authorityGroup = authorityGroup;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
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
}

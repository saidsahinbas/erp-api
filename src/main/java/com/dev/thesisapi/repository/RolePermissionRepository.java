package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface RolePermissionRepository extends CrudRepository<RolePermission, Integer> {
    List<RolePermission> findByAuthorityGroup(AuthorityGroup authorityGroup);

    List<RolePermission> findByAuthorityGroupId(Integer id);
}

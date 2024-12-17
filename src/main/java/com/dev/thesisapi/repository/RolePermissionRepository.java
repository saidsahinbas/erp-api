package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    List<RolePermission> findByAuthorityGroup(AuthorityGroup authorityGroup);
}

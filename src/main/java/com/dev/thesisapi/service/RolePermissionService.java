package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.repository.RolePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    public void saveRolePermission(RolePermission rolePermission) {
        rolePermissionRepository.save(rolePermission);
    }

    public List<RolePermission> getPermissionsByAuthorityGroup(Integer id) {
        return rolePermissionRepository.findByAuthorityGroupId(id);
    }
}

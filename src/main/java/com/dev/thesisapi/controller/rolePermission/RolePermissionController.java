package com.dev.thesisapi.controller.rolePermission;

import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.service.RolePermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rolePermission")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @GetMapping("{id}/permissions")
    public List<RolePermission> getPermissionsByAuthorityGroup(@PathVariable Integer id) {
        return rolePermissionService.getPermissionsByAuthorityGroup(id);
    }
}

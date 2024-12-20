package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.AuthorityGroupCreateDto;
import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.repository.AuthorityGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    private final AuthorityGroupRepository authorityGroupRepository;
    private final ScreenService screenService;
    private final RolePermissionService rolePermissionService;

    public AuthorityService(AuthorityGroupRepository authorityGroupRepository, ScreenService screenService, RolePermissionService rolePermissionService) {
        this.authorityGroupRepository = authorityGroupRepository;
        this.screenService = screenService;
        this.rolePermissionService = rolePermissionService;
    }

    public List<AuthorityGroup> getAllAuthorityGroups() {
        return authorityGroupRepository.findAll();
    }

    public Boolean create(AuthorityGroupCreateDto authorityGroupDto) {
        try{
            //save authority group
            AuthorityGroup authorityGroup = new AuthorityGroup();
            authorityGroup.setName(authorityGroupDto.getGroupName());
            var authorityGroupNew = authorityGroupRepository.save(authorityGroup);

            for (var rolePermissionInfo : authorityGroupDto.getRolePermissionItems()) {
                var screen = screenService.getById(rolePermissionInfo.getScreenId());
                RolePermission rolePermission = new RolePermission();
                rolePermission.setAuthorityGroup(authorityGroupNew);
                rolePermission.setScreen(screen);
                rolePermission.setCreate(rolePermissionInfo.getCreate());
                rolePermission.setRead(rolePermissionInfo.getRead());
                rolePermission.setUpdate(rolePermissionInfo.getUpdate());
                rolePermission.setDelete(rolePermissionInfo.getDelete());
                rolePermissionService.saveRolePermission(rolePermission);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

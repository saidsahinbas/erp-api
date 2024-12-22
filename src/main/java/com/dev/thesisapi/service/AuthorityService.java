package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.authority.AuthorityGroupAddUserDto;
import com.dev.thesisapi.dto.authority.AuthorityGroupCreateDto;
import com.dev.thesisapi.dto.authority.AuthorityGroupDeleteUserDto;
import com.dev.thesisapi.dto.authority.AuthorityGroupUpdateDto;
import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.repository.AuthorityGroupRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    private final AuthorityGroupRepository authorityGroupRepository;
    private final ScreenService screenService;
    private final RolePermissionService rolePermissionService;
    private final UserService userService;

    public AuthorityService(AuthorityGroupRepository authorityGroupRepository, ScreenService screenService, RolePermissionService rolePermissionService, UserService userService) {
        this.authorityGroupRepository = authorityGroupRepository;
        this.screenService = screenService;
        this.rolePermissionService = rolePermissionService;
        this.userService = userService;
    }

    public List<AuthorityGroup> getAllAuthorityGroups() {
        return authorityGroupRepository.findAll();
    }

    public Boolean create(AuthorityGroupCreateDto authorityGroupDto) {
        try {
            // Save authority group
            AuthorityGroup authorityGroup = new AuthorityGroup();
            authorityGroup.setName(authorityGroupDto.getGroupName());
            var authorityGroupNew = authorityGroupRepository.save(authorityGroup);

            for (var rolePermissionInfo : authorityGroupDto.getRolePermissionItems()) {
                var screen = screenService.getById(rolePermissionInfo.getScreenId());
                RolePermission rolePermission = new RolePermission();
                rolePermission.setAuthorityGroup(authorityGroupNew); // No need to re-query
                rolePermission.setScreen(screen);
                rolePermission.setCreate(rolePermissionInfo.getCreate());
                rolePermission.setRead(rolePermissionInfo.getRead());
                rolePermission.setUpdate(rolePermissionInfo.getUpdate());
                rolePermission.setDelete(rolePermissionInfo.getDelete());
                rolePermissionService.saveRolePermission(rolePermission);
            }
            return true;
        } catch (DataIntegrityViolationException e) {
            // Log duplicate key error
            System.err.println("Duplicate key error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            // Log general error
            System.err.println("Error creating authority group: " + e.getMessage());
            return false;
        }
    }

    public AuthorityGroup getAuthorityGroup(Integer id) {
        return authorityGroupRepository.findById(id).orElse(null);
    }

    public void update(AuthorityGroupUpdateDto authorityGroupDto) {
        //update authority group
        AuthorityGroup authorityGroup = authorityGroupRepository.findById(authorityGroupDto.getId()).orElse(null);
        authorityGroup.setName(authorityGroupDto.getGroupName());
        var authorityGroupNew = authorityGroupRepository.save(authorityGroup);

        //rolePermission update and create
        for (var rolePermissionInfo : authorityGroupDto.getRolePermissionItems()) {
            RolePermission rolePermission = rolePermissionService.getPermissionByAuthorityAndScreen(authorityGroup.getId(), rolePermissionInfo.getScreenId());
            rolePermission.setUpdate(rolePermissionInfo.getUpdate());
            rolePermission.setDelete(rolePermissionInfo.getDelete());
            rolePermission.setRead(rolePermissionInfo.getRead());
            rolePermission.setCreate(rolePermissionInfo.getCreate());
            rolePermissionService.saveRolePermission(rolePermission);
        }

    }

    public List<User> addUser(AuthorityGroupAddUserDto authorityGroupDto) {
        AuthorityGroup authorityGroup = authorityGroupRepository.findById(authorityGroupDto.getId()).orElse(null);
        for (var userInfo : authorityGroupDto.getUserIds()){
            User user = userService.getUser(userInfo);
            user.setAuthorityGroup(authorityGroup);
            userService.save(user);
        }

        return userService.getUsersByAuthorityGroup(authorityGroupDto.getId());
    }

    public List<User> deleteUser(AuthorityGroupDeleteUserDto authorityGroupDeleteUserDto) {
        User user = userService.getUser(authorityGroupDeleteUserDto.getUserId());
        user.setAuthorityGroup(null);
        userService.save(user);

        return userService.getUsersByAuthorityGroup(authorityGroupDeleteUserDto.getId());
    }
}

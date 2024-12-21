package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.UserCreateDto;
import com.dev.thesisapi.dto.UserLoginRequestDto;
import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RolePermissionRepository rolePermissionsRepository;
    private final AuthorityGroupRepository authorityGroupRepository;
    private final ScreenRepository screenRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, RolePermissionRepository rolePermissionsRepository, AuthorityGroupRepository authorityGroupRepository, ScreenRepository screenRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.rolePermissionsRepository = rolePermissionsRepository;
        this.authorityGroupRepository = authorityGroupRepository;
        this.screenRepository = screenRepository;
    }

    public Boolean login(UserLoginRequestDto userLoginRequest) {
        User user = userRepository.findByEmail(userLoginRequest.getEmail());

        if (user.getPassword().equals(userLoginRequest.getPassword())) {
            return true;
        }
        return false;
    }

    public Boolean logout() {

        return true;
    }

    public Map<String, Object> getUserSessionData(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            //TODO: Change this to a more specific exception
            throw new RuntimeException("User not found");
        }

        Map<String, Object> userSessionData = new HashMap<>();
        userSessionData.put("id", user.getId());
        userSessionData.put("firstName", user.getFirstName());
        userSessionData.put("lastName", user.getLastName());
        userSessionData.put("email", user.getEmail());
        userSessionData.put("role", roleRepository.findById(user.getRole().getId()).orElse(null));

        List<RolePermission> permissions = rolePermissionsRepository.findByAuthorityGroup(user.getAuthorityGroup());
        List<Map<String, Object>> screens = new ArrayList<>();

        for (RolePermission permission : permissions) {
            Screen screen = screenRepository.findById(permission.getScreen().getId()).orElse(null);
            if (screen != null) {
                Map<String, Object> screenData = new HashMap<>();
                screenData.put("screenName", screen.getName());
                screenData.put("read", permission.getRead());
                screenData.put("create", permission.getCreate());
                screenData.put("update", permission.getUpdate());
                screenData.put("delete", permission.getDelete());
                screens.add(screenData);
            }
        }

        userSessionData.put("screens", screens);

        return userSessionData;
    }

    public User createUser(UserCreateDto user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(roleRepository.findById(user.getRoleId()).orElse(null));
        newUser.setAuthorityGroup(authorityGroupRepository.findById(user.getAuthorityGroupId()).get());
        newUser.setStatus(user.getStatus().equals("active"));

        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByAuthorityGroup(Integer id) {
        return userRepository.findByAuthorityGroup(authorityGroupRepository.findById(id).get());
    }

    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<Long> getUserIdsByAuthorityId(Integer authorityId) {
        List<User> userList = userRepository.findByAuthorityGroup_Id(authorityId);
        List<Long> userIds = userList.stream().map(User::getId).collect(Collectors.toList());
        return userIds;
    }

    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}

package com.dev.thesisapi.service;

import com.dev.thesisapi.dto.UserLoginRequestDto;
import com.dev.thesisapi.entity.RolePermission;
import com.dev.thesisapi.entity.Screen;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.repository.RolePermissionRepository;
import com.dev.thesisapi.repository.RoleRepository;
import com.dev.thesisapi.repository.ScreenRepository;
import com.dev.thesisapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RolePermissionRepository rolePermissionsRepository;
    private final ScreenRepository screenRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, RolePermissionRepository rolePermissionsRepository, ScreenRepository screenRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.rolePermissionsRepository = rolePermissionsRepository;
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
}

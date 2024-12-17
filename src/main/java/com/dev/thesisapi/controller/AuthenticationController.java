package com.dev.thesisapi.controller;

import com.dev.thesisapi.dto.UserLoginRequestDto;
import com.dev.thesisapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginRequestDto userLoginRequest) {
        boolean isAuthenticated = userService.login(userLoginRequest);

        if (isAuthenticated) {
            Map<String, Object> userSessionData = userService.getUserSessionData(userLoginRequest.getEmail());
            userSessionData.put("isAuthenticated", true);
            return ResponseEntity.ok(userSessionData);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("isAuthenticated", false);
        response.put("message", "Invalid email or password");
        return ResponseEntity.status(401).body(response);
    }

    @GetMapping("logout")
    public Boolean logout() {
        return userService.logout();
    }
}

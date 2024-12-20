package com.dev.thesisapi.controller.user;

import com.dev.thesisapi.dto.UserCreateDto;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody  UserCreateDto user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}

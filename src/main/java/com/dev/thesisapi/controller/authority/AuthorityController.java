package com.dev.thesisapi.controller.authority;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.service.AuthorityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authority")
public class AuthorityController {

    private final AuthorityService authorityService;

    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @GetMapping("all")
    public List<AuthorityGroup> getAllAuthorityGroups() {
        return authorityService.getAllAuthorityGroups();
    }

}

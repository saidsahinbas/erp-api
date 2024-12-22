package com.dev.thesisapi.controller.authority;

import com.dev.thesisapi.dto.AuthorityGroupAddUserDto;
import com.dev.thesisapi.dto.AuthorityGroupCreateDto;
import com.dev.thesisapi.dto.AuthorityGroupDeleteUserDto;
import com.dev.thesisapi.dto.AuthorityGroupUpdateDto;
import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("create")
    public Boolean createAuthorityGroup(@RequestBody AuthorityGroupCreateDto authorityGroupDto) {
        return authorityService.create(authorityGroupDto);
    }

    @GetMapping("{id}")
    public AuthorityGroup getAuthorityGroup(@PathVariable Integer id) {
        return authorityService.getAuthorityGroup(id);
    }

    @PostMapping("update")
    public void updateAuthorityGroup(@RequestBody AuthorityGroupUpdateDto authorityGroupDto) {
        authorityService.update(authorityGroupDto);
    }

    @PostMapping("adduser")
    public List<User> addUserToAuthorityGroup(@RequestBody AuthorityGroupAddUserDto authorityGroupDto) {
        return authorityService.addUser(authorityGroupDto);
    }

    @PostMapping("removeUser")
    public List<User> removeUserFromAuthorityGroup(@RequestBody AuthorityGroupDeleteUserDto authorityGroupDeleteUserDto) {
        return authorityService.deleteUser(authorityGroupDeleteUserDto);
    }
}

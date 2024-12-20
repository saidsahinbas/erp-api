package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.repository.AuthorityGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    private final AuthorityGroupRepository authorityGroupRepository;

    public AuthorityService(AuthorityGroupRepository authorityGroupRepository) {
        this.authorityGroupRepository = authorityGroupRepository;
    }

    public List<AuthorityGroup> getAllAuthorityGroups() {
        return authorityGroupRepository.findAll();
    }
}

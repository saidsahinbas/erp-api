package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface AuthorityGroupRepository extends CrudRepository<AuthorityGroup, Integer> {
    List<AuthorityGroup> findAll();
    AuthorityGroup save(AuthorityGroup entity);
}

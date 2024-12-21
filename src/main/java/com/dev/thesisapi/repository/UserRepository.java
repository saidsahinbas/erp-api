package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.AuthorityGroup;
import com.dev.thesisapi.entity.User;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findAll();

    List<User> findByAuthorityGroup(AuthorityGroup authorityGroup);

    List<User> findByAuthorityGroup_Id(Integer authorityGroupId);
}

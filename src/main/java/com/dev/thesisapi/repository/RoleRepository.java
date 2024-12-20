package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Role;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    List<Role> findAll();
}

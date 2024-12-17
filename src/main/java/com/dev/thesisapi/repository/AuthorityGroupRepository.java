package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.AuthorityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityGroupRepository extends JpaRepository<AuthorityGroup, Integer> {
}

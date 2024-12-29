package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.Country;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findAll();
}

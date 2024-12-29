package com.dev.thesisapi.repository;

import com.dev.thesisapi.entity.City;
import com.dev.thesisapi.repository.base.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    List<City> findAllByCountry_Id(Integer countryId);
}

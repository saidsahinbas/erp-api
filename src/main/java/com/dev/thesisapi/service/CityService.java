package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.City;
import com.dev.thesisapi.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public List<City> getCityByCountry(Integer countryId) {
        return cityRepository.findAllByCountry_Id(countryId);
    }
}

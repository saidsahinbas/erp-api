package com.dev.thesisapi.service;

import com.dev.thesisapi.entity.City;
import com.dev.thesisapi.entity.Country;
import com.dev.thesisapi.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

}

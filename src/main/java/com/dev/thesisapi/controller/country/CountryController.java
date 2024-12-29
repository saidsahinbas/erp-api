package com.dev.thesisapi.controller.country;

import com.dev.thesisapi.entity.City;
import com.dev.thesisapi.entity.Country;
import com.dev.thesisapi.service.CityService;
import com.dev.thesisapi.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private final CountryService countryService;
    private final CityService cityService;

    public CountryController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping("all")
    public List<Country> getAllCountries(){
        return countryService.getAll();
    }

    @GetMapping("getCity")
    public List<City> getCityByCountry(@RequestParam("countryId") Integer countryId){
       return cityService.getCityByCountry(countryId);
    }
}

package com.github.fabiodelabruna.citiesapi.resource;

import com.github.fabiodelabruna.citiesapi.model.Country;
import com.github.fabiodelabruna.citiesapi.repository.CountryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository countryRepository;

    public CountryResource(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> countries() {
        return countryRepository.findAll();
    }

}

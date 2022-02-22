package com.github.fabiodelabruna.citiesapi.resource;

import com.github.fabiodelabruna.citiesapi.model.Country;
import com.github.fabiodelabruna.citiesapi.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository countryRepository;

    public CountryResource(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public Page<Country> countries(final Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable final Long id) {
        final Optional<Country> countryOptional = countryRepository.findById(id);
        return countryOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}

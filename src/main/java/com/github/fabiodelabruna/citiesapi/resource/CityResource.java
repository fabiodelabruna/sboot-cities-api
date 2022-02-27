package com.github.fabiodelabruna.citiesapi.resource;

import com.github.fabiodelabruna.citiesapi.model.City;
import com.github.fabiodelabruna.citiesapi.model.State;
import com.github.fabiodelabruna.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private final CityRepository cityRepository;

    public CityResource(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> states(final Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getOne(@PathVariable final Long id) {
        final Optional<City> cityOptional = cityRepository.findById(id);
        return cityOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}

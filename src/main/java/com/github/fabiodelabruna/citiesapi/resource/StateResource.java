package com.github.fabiodelabruna.citiesapi.resource;

import com.github.fabiodelabruna.citiesapi.model.State;
import com.github.fabiodelabruna.citiesapi.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(final StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public Page<State> states(final Pageable pageable) {
        return stateRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getOne(@PathVariable final Long id) {
        final Optional<State> stateOptional = stateRepository.findById(id);
        return stateOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}

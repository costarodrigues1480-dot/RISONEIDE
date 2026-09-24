package com.devshowcase.api.controller;

import com.devshowcase.api.domain.Technology;
import com.devshowcase.api.dto.request.TechnologyRequest;
import com.devshowcase.api.dto.response.TechnologyResponse;
import com.devshowcase.api.mapper.TechnologyMapper;
import com.devshowcase.api.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyResponse> create(
            @Valid @RequestBody TechnologyRequest request) {

        if (technologyService.existsByName(request.name())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Technology technology = TechnologyMapper.toEntity(request);
        Technology savedTechnology = technologyService.create(technology);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TechnologyMapper.toResponse(savedTechnology));
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponse>> findAll() {

        List<TechnologyResponse> technologies = technologyService.findAll()
                .stream()
                .map(TechnologyMapper::toResponse)
                .toList();

        return ResponseEntity.ok(technologies);
    }
}
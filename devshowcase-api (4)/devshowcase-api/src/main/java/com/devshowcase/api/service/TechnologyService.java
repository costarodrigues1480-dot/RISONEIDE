package com.devshowcase.api.service;

import com.devshowcase.api.domain.Technology;
import com.devshowcase.api.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

private final TechnologyRepository technologyRepository;

public TechnologyService(TechnologyRepository technologyRepository) {
    this.technologyRepository = technologyRepository;
}

public Technology create(Technology technology) {
    return technologyRepository.save(technology);
}

public List<Technology> findAll() {
    return technologyRepository.findAll();
}

public boolean existsByName(String name) {
    return technologyRepository.findByName(name).isPresent();
}

}


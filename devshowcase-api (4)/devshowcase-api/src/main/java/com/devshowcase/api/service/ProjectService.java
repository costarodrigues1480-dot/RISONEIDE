package com.devshowcase.api.service;

import com.devshowcase.api.domain.Profile;
import com.devshowcase.api.domain.Project;
import com.devshowcase.api.domain.Technology;
import com.devshowcase.api.dto.request.ProjectRequest;
import com.devshowcase.api.repository.ProfileRepository;
import com.devshowcase.api.repository.ProjectRepository;
import com.devshowcase.api.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ProjectService {

private final ProjectRepository projectRepository;
private final ProfileRepository profileRepository;
private final TechnologyRepository technologyRepository;

public ProjectService(
        ProjectRepository projectRepository,
        ProfileRepository profileRepository,
        TechnologyRepository technologyRepository) {

    this.projectRepository = projectRepository;
    this.profileRepository = profileRepository;
    this.technologyRepository = technologyRepository;
}

public Project create(ProjectRequest request) {

    Profile profile = profileRepository.findById(request.profileId())
            .orElseThrow(() ->
                    new RuntimeException("Perfil não encontrado"));

    Project project = new Project();

    project.setTitle(request.title());
    project.setRepoUrl(request.repoUrl());
    project.setLiveUrl(request.liveUrl());
    project.setCoverImageUrl(request.coverImageUrl());
    project.setDescription(request.description());

    if (request.status() != null) {
        project.setStatus(request.status());
    }

    project.setProfile(profile);

    if (request.technologyIds() != null) {
        List<Technology> technologies =
                technologyRepository.findAllById(request.technologyIds());

        project.setTechnologies(new HashSet<>(technologies));
    }

    return projectRepository.save(project);
}

public List<Project> findAll() {
    return projectRepository.findAll();
}

}


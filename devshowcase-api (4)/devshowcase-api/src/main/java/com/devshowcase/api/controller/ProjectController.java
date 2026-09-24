package com.devshowcase.api.controller;

import com.devshowcase.api.domain.Project;
import com.devshowcase.api.dto.request.ProjectRequest;
import com.devshowcase.api.dto.response.ProjectResponse;
import com.devshowcase.api.mapper.ProjectMapper;
import com.devshowcase.api.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> create(
            @Valid @RequestBody ProjectRequest request) {

        Project project = projectService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ProjectMapper.toResponse(project));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findAll() {

        List<ProjectResponse> projects = projectService.findAll()
                .stream()
                .map(ProjectMapper::toResponse)
                .toList();

        return ResponseEntity.ok(projects);
    }
}

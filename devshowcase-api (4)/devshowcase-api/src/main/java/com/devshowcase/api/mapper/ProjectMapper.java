package com.devshowcase.api.mapper;

import com.devshowcase.api.domain.Project;
import com.devshowcase.api.dto.response.ProjectResponse;

import java.util.List;

public class ProjectMapper {

    public static ProjectResponse toResponse(Project project) {

        List<com.devshowcase.api.dto.response.TechnologyResponse> technologies =
                project.getTechnologies()
                        .stream()
                        .map(TechnologyMapper::toResponse)
                        .toList();

        double averageRating = project.getFeedbacks()
                .stream()
                .filter(feedback -> feedback.getRating() != null)
                .mapToInt(feedback -> feedback.getRating())
                .average()
                .orElse(0.0);

        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getRepoUrl(),
                project.getLiveUrl(),
                project.getStatus().name(),
                ProfileMapper.toSummary(project.getProfile()),
                technologies,
                averageRating,
                project.getFeedbacks().size()
        );
    }
}

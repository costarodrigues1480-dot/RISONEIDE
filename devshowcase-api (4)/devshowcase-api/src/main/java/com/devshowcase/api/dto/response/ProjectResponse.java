package com.devshowcase.api.dto.response;

import java.util.List;

public record ProjectResponse(
        Long id,
        String title,
        String repoUrl,
        String liveUrl,
        String status,
        ProfileSummary profile,
        List<TechnologyResponse> technologies,
        Double averageRating,
        long feedbackCount
) {
}

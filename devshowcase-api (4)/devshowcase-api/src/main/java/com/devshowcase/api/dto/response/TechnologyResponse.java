package com.devshowcase.api.dto.response;

public record TechnologyResponse(
        Long id,
        String name,
        String category,
        String description,
        String officialUrl
) {
}

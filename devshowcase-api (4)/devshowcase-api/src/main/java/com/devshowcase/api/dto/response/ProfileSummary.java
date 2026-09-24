package com.devshowcase.api.dto.response;

public record ProfileSummary(
        Long id,
        String fullName,
        String email
) {
}

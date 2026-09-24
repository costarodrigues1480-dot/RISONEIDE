package com.devshowcase.api.dto.response;

public record FeedbackResponse(
        Long id,
        String authorName,
        String authorEmail,
        String comment,
        Integer rating,
        String createdAt
) {
}

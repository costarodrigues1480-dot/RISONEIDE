package com.devshowcase.api.mapper;

import com.devshowcase.api.domain.Feedback;
import com.devshowcase.api.dto.response.FeedbackResponse;

public class FeedbackMapper {

    public static FeedbackResponse toResponse(Feedback feedback) {
        return new FeedbackResponse(
                feedback.getId(),
                feedback.getAuthorName(),
                feedback.getAuthorEmail(),
                feedback.getComment(),
                feedback.getRating(),
                feedback.getCreatedAt() != null
                        ? feedback.getCreatedAt().toString()
                        : null
        );
    }
}

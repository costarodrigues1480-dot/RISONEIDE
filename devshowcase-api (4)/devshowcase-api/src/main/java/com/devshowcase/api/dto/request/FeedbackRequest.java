package com.devshowcase.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FeedbackRequest(

        @NotBlank(message = "authorName é obrigatório")
        String authorName,

        @Email(message = "authorEmail inválido")
        String authorEmail,

        @NotBlank(message = "comment é obrigatório")
        @Size(max = 1000)
        String comment,

        @Min(1)
        @Max(5)
        Integer rating
) {
}
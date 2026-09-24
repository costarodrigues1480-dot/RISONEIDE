package com.devshowcase.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfileRequest(

        @NotBlank(message = "fullName é obrigatório")
        @Size(max = 120)
        String fullName,

        @NotBlank
        @Email(message = "email inválido")
        String email,

        String headline,

        @Size(max = 500)
        String bio,

        String location,
        String avatarUrl,
        String githubUsername
) {
}

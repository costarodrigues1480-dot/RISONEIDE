package com.devshowcase.api.dto.request;

import com.devshowcase.api.domain.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record ProjectRequest(

        @NotBlank(message = "title é obrigatório")
        @Size(max = 150)
        String title,

        @NotBlank(message = "repoUrl é obrigatório")
        @Pattern(
                regexp = "^https?://.+",
                message = "repoUrl deve ser uma URL válida"
        )
        String repoUrl,

        @Pattern(
                regexp = "^https?://.+",
                message = "liveUrl deve ser uma URL válida"
        )
        String liveUrl,

        String coverImageUrl,

        @Size(max = 2000)
        String description,

        ProjectStatus status,

        @NotNull(message = "profileId é obrigatório")
        Long profileId,

        Set<Long> technologyIds
) {
}

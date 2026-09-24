package com.devshowcase.api.dto.request;

import com.devshowcase.api.domain.TechnologyCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TechnologyRequest(

        @NotBlank(message = "name é obrigatório")
        @Size(max = 80)
        String name,

        @NotNull(message = "category é obrigatória")
        TechnologyCategory category,

        String description,

        @Pattern(
                regexp = "^https?://.+",
                message = "officialUrl deve ser uma URL válida"
        )
        String officialUrl
) {
}

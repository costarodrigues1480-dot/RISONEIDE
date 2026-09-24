package com.devshowcase.api.mapper;

import com.devshowcase.api.domain.Technology;
import com.devshowcase.api.dto.request.TechnologyRequest;
import com.devshowcase.api.dto.response.TechnologyResponse;

public class TechnologyMapper {

    public static Technology toEntity(TechnologyRequest request) {
        Technology technology = new Technology();

        technology.setName(request.name());
        technology.setCategory(request.category());
        technology.setDescription(request.description());
        technology.setOfficialUrl(request.officialUrl());

        return technology;
    }

    public static TechnologyResponse toResponse(Technology technology) {
        return new TechnologyResponse(
                technology.getId(),
                technology.getName(),
                technology.getCategory().name(),
                technology.getDescription(),
                technology.getOfficialUrl()
        );
    }
}
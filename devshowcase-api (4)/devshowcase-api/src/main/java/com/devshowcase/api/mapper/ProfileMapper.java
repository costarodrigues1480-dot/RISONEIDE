package com.devshowcase.api.mapper;

import com.devshowcase.api.domain.Profile;
import com.devshowcase.api.dto.request.ProfileRequest;
import com.devshowcase.api.dto.response.ProfileSummary;

public class ProfileMapper {

    public static Profile toEntity(ProfileRequest request) {
        Profile profile = new Profile();

        profile.setFullName(request.fullName());
        profile.setEmail(request.email());
        profile.setHeadline(request.headline());
        profile.setBio(request.bio());
        profile.setLocation(request.location());
        profile.setAvatarUrl(request.avatarUrl());
        profile.setGithubUsername(request.githubUsername());

        return profile;
    }

    public static ProfileSummary toSummary(Profile profile) {
        return new ProfileSummary(
                profile.getId(),
                profile.getFullName(),
                profile.getEmail()
        );
    }
}
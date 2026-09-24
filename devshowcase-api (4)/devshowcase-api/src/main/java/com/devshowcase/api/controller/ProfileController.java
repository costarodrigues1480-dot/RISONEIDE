package com.devshowcase.api.controller;

import com.devshowcase.api.domain.Profile;
import com.devshowcase.api.dto.request.ProfileRequest;
import com.devshowcase.api.dto.response.ProfileSummary;
import com.devshowcase.api.mapper.ProfileMapper;
import com.devshowcase.api.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileSummary> create(
            @Valid @RequestBody ProfileRequest request) {

        if (profileService.existsByEmail(request.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Profile profile = ProfileMapper.toEntity(request);

        Profile savedProfile = profileService.create(profile);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ProfileMapper.toSummary(savedProfile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileSummary> findById(@PathVariable Long id) {

        Profile profile = profileService.findById(id);

        return ResponseEntity.ok(
                ProfileMapper.toSummary(profile)
        );
    }
}

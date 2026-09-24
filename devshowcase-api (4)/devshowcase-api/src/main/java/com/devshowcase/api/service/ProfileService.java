package com.devshowcase.api.service;

import com.devshowcase.api.domain.Profile;
import com.devshowcase.api.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile findById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }

    public boolean existsByEmail(String email) {
        return profileRepository.findByEmail(email).isPresent();
    }
}
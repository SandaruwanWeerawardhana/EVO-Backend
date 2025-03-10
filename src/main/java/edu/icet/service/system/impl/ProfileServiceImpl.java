package edu.icet.service.system.impl;

import edu.icet.dto.Profile;
import edu.icet.service.system.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileServiceImpl implements ProfileService {
    @Override
    public Profile addProfile(Profile profile) {
        return null;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return null;
    }

    @Override
    public Optional<Profile> getProfileById(Integer profileId) {
        return Optional.empty();
    }

    @Override
    public List<Profile> getAllProfiles() {
        return List.of();
    }

    @Override
    public void deleteProfile(Integer profileId) {

    }

    @Override
    public List<Profile> getProfilesByGender(String gender) {
        return List.of();
    }

    @Override
    public List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge) {
        return List.of();
    }
}

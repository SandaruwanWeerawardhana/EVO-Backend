package edu.icet.service;

import edu.icet.dto.Profile;
import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile updateProfile(Profile profile);
    Optional<Profile> getProfileById(Integer profileId);
    List<Profile> getAllProfiles();
    void deleteProfile(Integer profileId);
    List<Profile> getProfilesByGender(String gender);
    List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge);
}
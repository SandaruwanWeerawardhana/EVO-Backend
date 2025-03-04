package edu.icet.service;

import edu.icet.dto.Profile;
import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile addProfile(Profile profileDTO);
    Profile updateProfile(Long profileId, Profile profileDTO);
    Optional<Profile> getProfileById(Long profileId);
    List<Profile> getAllProfiles();
    void deleteProfile(Long profileId);
    List<Profile> getProfilesByGender(String gender);
    List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge);
}
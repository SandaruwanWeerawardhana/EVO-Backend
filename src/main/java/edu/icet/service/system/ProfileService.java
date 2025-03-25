package edu.icet.service.system;

import edu.icet.dto.system.Profile;

import java.util.List;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile updateProfile(Profile profile);
    Profile getProfileById(Long profileId);
    List<Profile> getAllProfiles();
    void deleteProfile(Long profileId);
}
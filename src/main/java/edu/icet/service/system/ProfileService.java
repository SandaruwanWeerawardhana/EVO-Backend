package edu.icet.service.system;

import edu.icet.dto.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile updateProfile(Profile profile);
    Profile getProfileById(Long profileId);
    List<Profile> getAllProfiles();
    void deleteProfile(Long profileId);
}
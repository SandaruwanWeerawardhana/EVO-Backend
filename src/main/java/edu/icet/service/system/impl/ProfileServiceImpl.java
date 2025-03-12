package edu.icet.service.system.impl;

import edu.icet.dto.Profile;
import edu.icet.service.system.ProfileService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {
    final List<Profile> profileList = new ArrayList<>();

    @Override
    public Profile addProfile(Profile profile) {
        profileList.add(profile);
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        for (int i = 0; i < profileList.size(); i++) {
            if (profileList.get(i).getId().equals(profile.getId())) {
                profileList.set(i, profile);
                return profile;
            }
        }
        throw new RuntimeException("Profile not found");
    }

    @Override
    public Optional<Profile> getProfileById(Integer profileId) {
        return profileList.stream()
                .filter(profile -> profile.getId().equals(profileId))
                .findFirst();
    }

    @Override
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profileList);
    }

    @Override
    public void deleteProfile(Integer profileId) {
        profileList.removeIf(profile -> profile.getId().equals(profileId));
    }

    @Override
    public List<Profile> getProfilesByGender(String gender) {
        return null;
    }

    @Override
    public List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge) {
        return null;
    }

//    @Override
//    public List<Profile> getProfilesByGender(String gender) {
//        return profileList.stream()
//                .filter(profile -> profile.getGender().equalsIgnoreCase(gender))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge) {
//        return profileList.stream()
//                .filter(profile -> profile.getAge() >= minAge && profile.getAge() <= maxAge)
//                .collect(Collectors.toList());
//    }
}
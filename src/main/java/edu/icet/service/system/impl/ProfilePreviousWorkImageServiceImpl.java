package edu.icet.service.system.impl;

import edu.icet.dto.ProfilePreviousWorkImage;
import edu.icet.service.system.ProfilePreviousWorkImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilePreviousWorkImageServiceImpl implements ProfilePreviousWorkImageService {

    private final List<ProfilePreviousWorkImage> profilePreviousWorkImageList = new ArrayList<>();

    @Override
    public ProfilePreviousWorkImage addPreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage) {
        profilePreviousWorkImageList.add(profilePreviousWorkImage);
        return profilePreviousWorkImage;
    }

    @Override
    public ProfilePreviousWorkImage updatePreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage) {
        for (int i = 0; i < profilePreviousWorkImageList.size(); i++) {
            if (profilePreviousWorkImageList.get(i).getProfilePreviousWorkImageId().equals(profilePreviousWorkImage.getProfilePreviousWorkImageId())) {
                profilePreviousWorkImageList.set(i, profilePreviousWorkImage);
                return profilePreviousWorkImage;
            }
        }
        return null;
    }

    @Override
    public List<ProfilePreviousWorkImage> getAllPreviousWorkImage() {
        return profilePreviousWorkImageList;
    }

    @Override
    public void deleteByProfilePreviousWorkImageId(Long profilePreviousWorkImageId) {
        profilePreviousWorkImageList.removeIf(image -> image.getProfilePreviousWorkImageId().equals(profilePreviousWorkImageId));
    }

    @Override
    public ProfilePreviousWorkImage searchByProfilePreviousWorkImageId(Long profilePreviousWorkImageId) {
        return profilePreviousWorkImageList.stream()
                .filter(img -> img.getProfilePreviousWorkImageId().equals(profilePreviousWorkImageId))
                .findFirst()
                .orElse(null);
    }
}

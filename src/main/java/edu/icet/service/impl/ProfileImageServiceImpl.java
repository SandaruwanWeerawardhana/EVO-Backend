package edu.icet.service.impl;

import edu.icet.dto.ProfileImage;
import edu.icet.service.ProfileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {
    final List<ProfileImage> profileImages = new ArrayList<>();

    @Override
    public void updateProfileImage(ProfileImage profileImage) {
        deleteProfileImage(profileImage.getUserId().intValue());
        profileImages.add(profileImage);
    }

    @Override
    public Optional<ProfileImage> getProfileImageByUserId(Integer userId) {
        return profileImages.stream()
                .filter(profileImage -> profileImage.getUserId().intValue() == userId)
                .findFirst();
    }

    @Override
    public void deleteProfileImage(Integer userId) {
        profileImages.removeIf(profileImage -> profileImage.getUserId().intValue() == userId);
    }
}
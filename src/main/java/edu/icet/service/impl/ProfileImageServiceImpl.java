package edu.icet.service.impl;

import edu.icet.dto.ProfileImage;
import edu.icet.service.ProfileImageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {
    final ProfileImageDao profileImageDao;

    @Override
    public void updateProfileImage(ProfileImage profileImage) {
        ProfileImageEntity profileImageEntity = new ProfileImageEntity();
        profileImageEntity.setUserId(profileImage.getUserId());
        try {
            profileImageEntity.setProfileImage(profileImage.getProfileImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error processing image file", e);
        }
        profileImageDao.save(profileImageEntity);
    }

    @Override
    public Optional<ProfileImage> getProfileImageByUserId(Integer userId) {
        return profileImageDao.findById(userId).map(entity -> {
            ProfileImage profileImage = new ProfileImage();
            profileImage.setUserId(entity.getUserId());
            profileImage.setProfileImage(new MockMultipartFile("profileImage", entity.getProfileImage()));
            return profileImage;
        });
    }

    @Override
    public void deleteProfileImage(Integer userId) {
        if (!profileImageDao.existsById(userId)) {
            throw new EntityNotFoundException("Profile image not found for user ID: " + userId);
        }
        profileImageDao.deleteById(userId);
    }
}
package edu.icet.service;

import edu.icet.dto.ProfileImage;
import java.util.Optional;

public interface ProfileImageService {
    void uploadProfileImage(Long userId, String profileImage);
    void updateProfileImage(Long userId, String profileImage);
    Optional<ProfileImage> getProfileImageByUserId(Long userId);
    void deleteProfileImage(Long userId);
}
package edu.icet.service;

import edu.icet.dto.ProfileImage;
import java.util.Optional;

public interface ProfileImageService {
    void updateProfileImage(ProfileImage profileImage);
    Optional<ProfileImage> getProfileImageByUserId(Integer userId);
    void deleteProfileImage(Integer userId);
}
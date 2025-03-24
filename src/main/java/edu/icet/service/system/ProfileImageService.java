package edu.icet.service.system;

import edu.icet.dto.supplier.ProfileImage;

import java.util.Optional;

public interface ProfileImageService {
    void updateProfileImage(ProfileImage profileImage);
    Optional<ProfileImage> getProfileImageByUserId(Integer userId);
    void deleteProfileImage(Integer userId);
}
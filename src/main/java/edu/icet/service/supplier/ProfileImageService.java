package edu.icet.service.supplier;

import edu.icet.dto.supplier.ProfileImage;

import java.util.Optional;

public interface ProfileImageService {

    ProfileImage addProfileImage(ProfileImage profileImage);
    ProfileImage updateProfileImage(ProfileImage profileImage);
    ProfileImage getProfileImage(Long id);
    Boolean deleteProfileImage(Long id);
}
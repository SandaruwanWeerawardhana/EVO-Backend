package edu.icet.service.system.impl;

import edu.icet.dto.ProfileImage;
import edu.icet.service.system.ProfileImageService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfileImageServiceImpl implements ProfileImageService {
    @Override
    public void updateProfileImage(ProfileImage profileImage) {

    }

    @Override
    public Optional<ProfileImage> getProfileImageByUserId(Integer userId) {
        return Optional.empty();
    }

    @Override
    public void deleteProfileImage(Integer userId) {

    }
}

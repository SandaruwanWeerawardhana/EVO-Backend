package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.ProfileImage;
import edu.icet.entity.supplier.ProfileImageEntity;
import edu.icet.repository.supplier.ProfileImageRepository;
import edu.icet.service.supplier.ProfileImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {

    private final ModelMapper mapper;
    private final ProfileImageRepository repository;

    @Override
    public ProfileImage addProfileImage(ProfileImage profileImage) {
        return mapper.map(repository.save(mapper.map(profileImage, ProfileImageEntity.class)), ProfileImage.class);
    }

    @Override
    public ProfileImage updateProfileImage(ProfileImage profileImage) {
        if (repository.existsById(profileImage.getId())) {
            return addProfileImage(profileImage);
        }

        throw new IllegalArgumentException("Profile Image does not exist!");
    }

    @Override
    public ProfileImage getProfileImage(Long id) {
        ProfileImageEntity entity = repository.findById(id).orElse(null);

        return entity != null
                ? mapper.map(entity, ProfileImage.class)
                : null;
    }

    @Override
    public Boolean deleteProfileImage(Long id) {
        repository.deleteById(id);

        return true;
    }
}

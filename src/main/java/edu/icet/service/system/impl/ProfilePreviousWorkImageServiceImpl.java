package edu.icet.service.system.impl;

import edu.icet.dto.ProfilePreviousWorkImage;
import edu.icet.entity.ProfilePreviousWorkImageEntity;
import edu.icet.repository.ProfilePreviousWorkImageRepository;
import edu.icet.service.system.ProfilePreviousWorkImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePreviousWorkImageServiceImpl implements ProfilePreviousWorkImageService {

    private final ModelMapper mapper;
    private final ProfilePreviousWorkImageRepository repository;

    @Override
    public ProfilePreviousWorkImage addPreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage) {
        return mapper.map(
                repository.save(
                        mapper.map(
                                profilePreviousWorkImage,
                                ProfilePreviousWorkImageEntity.class
                        )
                ), ProfilePreviousWorkImage.class);
    }

    @Override
    public ProfilePreviousWorkImage updatePreviousWorkImage(ProfilePreviousWorkImage profilePreviousWorkImage) {
        if (repository.existsById(profilePreviousWorkImage.getProfilePreviousWorkImageId())) {
            return mapper.map(
                    repository.save(mapper.map(
                            profilePreviousWorkImage,
                            ProfilePreviousWorkImageEntity.class
                    )), ProfilePreviousWorkImage.class
            );
        }

        throw new IllegalArgumentException("ProflePreviousWorkImage does not exist!");
    }

    @Override
    public List<ProfilePreviousWorkImage> getAllPreviousWorkImage() {
        return repository.findAll()
                .stream()
                .map(profilePreviousWorkImageEntity ->
                        mapper.map(profilePreviousWorkImageEntity, ProfilePreviousWorkImage.class)
                ).toList();
    }

    @Override
    public void deleteByProfilePreviousWorkImageId(Long profilePreviousWorkImageId) {
        if (repository.existsById(profilePreviousWorkImageId)) {
            repository.deleteById(profilePreviousWorkImageId);
            return;
        }

        throw new RuntimeException("ProfilePreviousWorkImage does not exist!");
    }

    @Override
    public ProfilePreviousWorkImage searchByProfilePreviousWorkImageId(Long profilePreviousWorkImageId) {
        ProfilePreviousWorkImageEntity entity = repository.findById(profilePreviousWorkImageId).orElse(null);

        return entity != null ? mapper.map(entity, ProfilePreviousWorkImage.class) : null;
    }
}

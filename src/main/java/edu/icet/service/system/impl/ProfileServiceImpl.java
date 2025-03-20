package edu.icet.service.system.impl;

import edu.icet.dto.Profile;
import edu.icet.entity.ProfileEntity;
import edu.icet.repository.ProfileRepository;
import edu.icet.service.system.ProfileService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final ModelMapper mapper;
    @Override
    public Profile addProfile(Profile profile) {
        return mapper.map(repository.save(mapper.map(profile, ProfileEntity.class)), Profile.class);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        if (repository.existsById(profile.getId())) {
            return mapper.map(repository.save(mapper.map(profile, ProfileEntity.class)), Profile.class);
        }
        throw new RuntimeException("Profile not found");
    }

    @Override
    public Profile getProfileById(Long profileId) {
        ProfileEntity entity = repository.findById(profileId).orElse(null);
        return entity != null ? mapper.map(entity, Profile.class) : null;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return repository.findAll()
                .stream()
                .map(profileEntity -> mapper.map(profileEntity, Profile.class))
                .toList();
    }

    @Override
    public void deleteProfile(Long profileId) {
        if (repository.existsById(profileId)) {
            repository.deleteById(profileId);
        }

        throw new IllegalArgumentException("Profile does not exist!");
    }


}
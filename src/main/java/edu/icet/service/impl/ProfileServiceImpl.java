package edu.icet.service.impl;

import edu.icet.dto.Profile;
import edu.icet.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    final ProfileDao profileDao;

    @Override
    public Profile addProfile(Profile profile) {
        return ProfileDao.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        if (profile.getId() == null || !ProfileDao.existsById(profile.getId())) {
            throw new EntityNotFoundException("Profile not found");
        }
        return ProfileDao.save(profile);
    }

    @Override
    public Optional<Profile> getProfileById(Integer profileId) {
        return ProfileDao.findById(profileId.longValue());
    }

    @Override
    public List<Profile> getAllProfiles() {
        return ProfileDao.findAll();
    }

    @Override
    public void deleteProfile(Integer profileId) {
        if (!ProfileDao.existsById(profileId.longValue())) {
            throw new EntityNotFoundException("Profile not found");
        }
        ProfileDao.deleteById(profileId.longValue());
    }

    @Override
    public List<Profile> getProfilesByGender(String gender) {
        return ProfileDao.findByGender(gender);
    }

    @Override
    public List<Profile> getProfilesByAgeRange(Integer minAge, Integer maxAge) {
        return ProfileDao.findByAgeBetween(minAge, maxAge);
    }
}
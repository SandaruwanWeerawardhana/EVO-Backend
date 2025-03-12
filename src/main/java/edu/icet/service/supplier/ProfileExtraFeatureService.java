package edu.icet.service.supplier;

import edu.icet.dto.ProfileExtraFeature;

import java.util.List;

public interface ProfileExtraFeatureService {
    List<ProfileExtraFeature> getAll();
    ProfileExtraFeature save(ProfileExtraFeature profileExtraFeature);
    Boolean delete(Long id);
    Boolean update(ProfileExtraFeature profileExtraFeature);
    ProfileExtraFeature searchById(Long id);
}

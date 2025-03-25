package edu.icet.service.supplier;

import edu.icet.dto.supplier.ProfileExtraFeature;

import java.util.List;

public interface ProfileExtraFeatureService {
    List<ProfileExtraFeature> getAll();
    Boolean save(ProfileExtraFeature profileExtraFeature);
    Boolean delete(Long id);
    Boolean update(Long id, ProfileExtraFeature profileExtraFeature);
    ProfileExtraFeature searchById(Long id);
}

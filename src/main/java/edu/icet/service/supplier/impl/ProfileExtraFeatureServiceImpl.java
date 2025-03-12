package edu.icet.service.supplier.impl;

import edu.icet.dto.ProfileExtraFeature;
import edu.icet.service.supplier.ProfileExtraFeatureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileExtraFeatureServiceImpl implements ProfileExtraFeatureService {
    final ModelMapper mapper;
    private final ArrayList<ProfileExtraFeature> profileExtraFeatures = new ArrayList<>();
    @Override
    public List<ProfileExtraFeature> getAll() {
        return profileExtraFeatures;
    }

    @Override
    public ProfileExtraFeature save(ProfileExtraFeature profileExtraFeature) {
      profileExtraFeatures.add(profileExtraFeature);
      return profileExtraFeature;
    }

    @Override
    public Boolean delete(Long id) {
        return profileExtraFeatures.removeIf(feature -> feature.getFeatureID().equals(id));
    }

    @Override
    public Boolean update(ProfileExtraFeature profileExtraFeature) {
        if (profileExtraFeature == null || profileExtraFeature.getFeatureID() == null) return false;

        for (ProfileExtraFeature feature : profileExtraFeatures) {
            if (feature.getFeatureID().equals(profileExtraFeature.getFeatureID())) {
                int index = profileExtraFeatures.indexOf(feature);
                profileExtraFeatures.set(index, profileExtraFeature);
                return true;
            }
        }
        return false;
    }

    @Override
    public ProfileExtraFeature searchById(Long id) {
        for (ProfileExtraFeature feature : profileExtraFeatures) {
            if (feature.getFeatureID().equals(id)) {
                return feature;
            }
        }
        return null;
    }
}

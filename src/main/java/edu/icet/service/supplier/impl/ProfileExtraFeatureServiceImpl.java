package edu.icet.service.supplier.impl;

import edu.icet.dto.ProfileExtraFeature;
import edu.icet.dto.VerificationRequest;
import edu.icet.entity.ProfileExtraFeatureEntity;
import edu.icet.entity.VerificationRequestEntity;
import edu.icet.repository.ProfileExtraFeatureRepository;
import edu.icet.service.supplier.ProfileExtraFeatureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileExtraFeatureServiceImpl implements ProfileExtraFeatureService {
    final ProfileExtraFeatureRepository repository;
    final ModelMapper mapper;


    @Override
    public List<ProfileExtraFeature> getAll() {
        List<ProfileExtraFeature> profileExtraFeatureList = new ArrayList<>();
        List<ProfileExtraFeatureEntity> all = repository.findAll();

        all.forEach(profileExtraFeatureEntity -> {
            profileExtraFeatureList.add(mapper.map(profileExtraFeatureEntity, ProfileExtraFeature.class));
        });

        return profileExtraFeatureList;
    }

    @Override
    public Boolean save(ProfileExtraFeature profileExtraFeature) {
        if (profileExtraFeature == null) {
            return false;
        }
        repository.save(mapper.map(profileExtraFeature, ProfileExtraFeatureEntity.class));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        if (id == null){
            return false;
        }
        if (!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(Long id, ProfileExtraFeature profileExtraFeature) {
        if (id == null) {
            return false;
        }
        if (!repository.existsById(id)) {
            return false;
        }
        repository.save(mapper.map(profileExtraFeature, ProfileExtraFeatureEntity.class));
        return true;
    }

    @Override
    public ProfileExtraFeature searchById(Long id) {
        if (id == null){
            return null;
        }
        if (!repository.existsById(id)){
            return null;
        }
        return mapper.map(repository.findById(id), ProfileExtraFeature.class);
    }
}

package edu.icet.service.supplier.impl;

import edu.icet.entity.supplier.PackageFeatureEntity;
import edu.icet.repository.supplier.ProfileExtraFeatureRepository;
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
    public List<edu.icet.dto.supplier.PackageFeature> getAll() {
        List<edu.icet.dto.supplier.PackageFeature> packageFeatureList = new ArrayList<>();
        List<PackageFeatureEntity> all = repository.findAll();

        all.forEach(packageFeatureEntity -> {
            packageFeatureList.add(mapper.map(packageFeatureEntity, edu.icet.dto.supplier.PackageFeature.class));
        });

        return packageFeatureList;
    }
    @Override
    public Boolean save(edu.icet.dto.supplier.PackageFeature packageFeature) {
        if (packageFeature == null) {
            return false;
        }
        if (repository.existsById(packageFeature.getFeatureID())) {
            throw new IllegalArgumentException("Already Exist Work");
        }
        repository.save(mapper.map(packageFeature, PackageFeatureEntity.class));
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
    public boolean deleteByNameAndPrice(String featureName,Double featurePrice){
        if (featureName==null || featurePrice==null){
            return false;
        }
        repository.deleteByFeaturePriceAndFeatureName(featurePrice,featureName);
        return true;
    }
    @Override
    public Boolean update(Long id, edu.icet.dto.supplier.PackageFeature packageFeature) {
        if (id == null) {
            return false;
        }
        if (!repository.existsById(id)) {
            return false;
        }

        repository.save(mapper.map(packageFeature, PackageFeatureEntity.class));
        return true;
    }
    @Override
    public edu.icet.dto.supplier.PackageFeature searchById(Long id) {
        if (id == null){
            return null;
        }
        if (!repository.existsById(id)){
            return null;
        }
        return mapper.map(repository.findById(id), edu.icet.dto.supplier.PackageFeature.class);
    }
}

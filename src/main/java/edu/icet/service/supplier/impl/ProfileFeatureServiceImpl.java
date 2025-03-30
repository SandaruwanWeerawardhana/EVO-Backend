package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.PackageFeature;
import edu.icet.entity.supplier.PackageFeatureEntity;
import edu.icet.repository.supplier.ProfileExtraFeatureRepository;
import edu.icet.service.supplier.PackageFeatureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileFeatureServiceImpl implements PackageFeatureService {
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
    public PackageFeature save(edu.icet.dto.supplier.PackageFeature packageFeature) {
        if (repository.existsById(packageFeature.getFeatureID())) {
            throw new IllegalArgumentException("Already Exist Work");
        }
        return mapper.map(repository.save(mapper.map(packageFeature, PackageFeatureEntity.class)), PackageFeature.class);

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
    public PackageFeature update(PackageFeature packageFeature) {

        if (!repository.existsById(packageFeature.getFeatureID())) {
            throw new IllegalArgumentException("Package feature does not exist!");
        }

        return mapper.map(repository.save(mapper.map(packageFeature, PackageFeatureEntity.class)), PackageFeature.class);
    }
    @Override
    public PackageFeature searchById(Long id) {
        if (id == null){
            return null;
        }
        if (!repository.existsById(id)){
            return null;
        }
        return mapper.map(repository.findById(id), edu.icet.dto.supplier.PackageFeature.class);
    }
}

package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.PackageFeature;
import edu.icet.dto.supplier.ProfilePackage;
import edu.icet.entity.supplier.PackageFeatureEntity;
import edu.icet.entity.supplier.ProfilePackageEntity;
import edu.icet.repository.supplier.ProfilePackageRepository;
import edu.icet.service.supplier.ProfilePackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProfilePackageServiceImpl implements ProfilePackageService {
    private final ModelMapper mapper;
    private final ProfilePackageRepository repository;

    @Override
    public ProfilePackage addPackage(ProfilePackage profilePackage) {

        if (repository.existsByPackageName(profilePackage.getPackageName())){
            throw new IllegalArgumentException("PackageName is already exits");
        }

        return mapper.map(repository.save(mapper.map(profilePackage, ProfilePackageEntity.class)), ProfilePackage.class);
    }

    @Override
    public List<ProfilePackage> getAllPackages() {
        List<ProfilePackageEntity> all = repository.findAll();

        List<ProfilePackage> profilePackages = new ArrayList<>();

        all.forEach(profilePackagesEntity -> {
            profilePackages.add(mapper.map(profilePackages, ProfilePackage.class));
        });
        return profilePackages;
    }

    @Override
    public List<ProfilePackage> getAllProfileById(Long profileId) {
        List<ProfilePackageEntity> all = repository.getAllByPackageId(profileId);

        List<ProfilePackage> profilePackages = new ArrayList<>();

        all.forEach(profilePackagesEntity -> {
            profilePackages.add(mapper.map(profilePackages, ProfilePackage.class));
        });
        return profilePackages;
    }

    @Override
    public ProfilePackage updatePackage(ProfilePackage profilePackage) {
        if (repository.existsById(profilePackage.getPackageId())) {

            return mapper.map(repository.save(mapper.map(profilePackage, ProfilePackageEntity.class)), ProfilePackage.class);
        }

        throw new IllegalArgumentException("Profile Package does not exist!");
    }

    @Override
    public Boolean deletePackageById(Long packageId) {
        repository.deleteById(packageId);

        return true;
    }

    @Override
    public ProfilePackage searchByPackageId(Long packageId) {
        return mapper.map(repository.findById(packageId), ProfilePackage.class);
    }

    @Override
    public ProfilePackage searchByPackageName(String packageName) {
        return mapper.map(repository.findByPackageName(packageName), ProfilePackage.class);
    }

    @Override
    public ProfilePackage searchByPackageFeature(PackageFeature features) {
        return mapper.map(
                repository.findByFeaturesIn(
                                List.of(mapper.map(features, PackageFeatureEntity.class))
                ), ProfilePackage.class);
    }
}

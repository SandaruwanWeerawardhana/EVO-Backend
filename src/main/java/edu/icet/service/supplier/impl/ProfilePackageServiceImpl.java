package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.ProfilePackage;
import edu.icet.entity.supplier.ProfilePackageEntity;
import edu.icet.repository.supplier.ProfilePackageRepository;
import edu.icet.service.supplier.ProfilePackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProfilePackageServiceImpl implements ProfilePackageService {
    private final ModelMapper mapper;
    private final ProfilePackageRepository repository;

    @Override
    public void addPackage(ProfilePackage profilePackage) {

        if (repository.existsByPackageName(profilePackage.getPackageName())){
            throw new IllegalArgumentException("PackageName is already exits");
        }

        repository.save(mapper.map(profilePackage, ProfilePackageEntity.class));
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
    public void updatePackage(ProfilePackage profilePackage) {
        repository.save(mapper.map(profilePackage, ProfilePackageEntity.class));
    }

    @Override
    public void deletePackageById(Long packageId) {
        repository.deleteById(packageId);
    }

    @Override
    public ProfilePackage searchByPackageId(Long packageId) {
        return mapper.map(repository.findById(packageId), ProfilePackage.class);
    }

    @Override
    public ProfilePackage searchByPackageName(String packageName) {
        return mapper.map(repository.findByPackageName(packageName), ProfilePackage.class);
    }
}

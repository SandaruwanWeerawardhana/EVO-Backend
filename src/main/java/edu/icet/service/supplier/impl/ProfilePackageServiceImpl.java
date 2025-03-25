package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.ProfilePackages;
import edu.icet.entity.supplier.ProfilePackagesEntity;
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
    public void addPackage(ProfilePackages profilePackage) {

        if (repository.existsPackageName(profilePackage.getPackageName())){
            throw new IllegalArgumentException("PackageName is already exits");
        }

        repository.save(mapper.map(profilePackage, ProfilePackagesEntity.class));
    }

    @Override
    public List<ProfilePackages> getAllPackages() {
        List<ProfilePackagesEntity> all = repository.findAll();

        List<ProfilePackages> profilePackages = new ArrayList<>();

        all.forEach(profilePackagesEntity -> {
            profilePackages.add(mapper.map(profilePackages,ProfilePackages.class));
        });
        return profilePackages;
    }

    @Override
    public List<ProfilePackages> getAllProfileById(Long profileId) {
        List<ProfilePackagesEntity> all = repository.getAllByPackageId(profileId);

        List<ProfilePackages> profilePackages = new ArrayList<>();

        all.forEach(profilePackagesEntity -> {
            profilePackages.add(mapper.map(profilePackages,ProfilePackages.class));
        });
        return profilePackages;
    }

    @Override
    public void updatePackage(ProfilePackages profilePackage) {
        repository.save(mapper.map(profilePackage, ProfilePackagesEntity.class));
    }

    @Override
    public void deletePackageById(Long packageId) {
        repository.deleteById(packageId);
    }

    @Override
    public ProfilePackages searchByPackageId(Long packageId) {
        return mapper.map(repository.findById(packageId),ProfilePackages.class);
    }

    @Override
    public ProfilePackages searchByPackageName(String packageName) {
        return mapper.map(repository.findByPackageName(packageName),ProfilePackages.class);
    }
}

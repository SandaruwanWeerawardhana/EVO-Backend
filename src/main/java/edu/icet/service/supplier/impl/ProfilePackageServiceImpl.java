package edu.icet.service.supplier.impl;

import edu.icet.dto.ProfilePackages;
import edu.icet.service.supplier.ProfilePackageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfilePackageServiceImpl implements ProfilePackageService {
    @Override
    public void addPackage(ProfilePackages profilePackages) {

    }

    @Override
    public List<ProfilePackages> getAllPackages() {
        return List.of();
    }

    @Override
    public List<ProfilePackages> getAllProfileById(Long profileId) {
        return List.of();
    }

    @Override
    public void updatePackage(ProfilePackages profilePackages) {

    }

    @Override
    public void deletePackageById(Long packageId) {

    }

    @Override
    public ProfilePackages searchByPackageId(Long packageId) {
        return null;
    }

    @Override
    public ProfilePackages searchByPackageName(String packageName) {
        return null;
    }
}

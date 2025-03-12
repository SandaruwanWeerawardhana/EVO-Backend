package edu.icet.service.supplier.impl;

import edu.icet.dto.ProfilePackages;
import edu.icet.dto.PropertyImage;
import edu.icet.service.supplier.ProfilePackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProfilePackageServiceImpl implements ProfilePackageService {
    final ModelMapper mapper;
    private ArrayList<ProfilePackages> profilePackages = new ArrayList<>();

    @Override
    public void addPackage(ProfilePackages profilePackage) {
        profilePackages.add(profilePackage);
    }

    @Override
    public List<ProfilePackages> getAllPackages() {
        return profilePackages;
    }

    @Override
    public List<ProfilePackages> getAllProfileById(Long profileId) {
        List<ProfilePackages> result = new ArrayList<>();
        for (ProfilePackages packageItem : profilePackages) {
            if (packageItem.getProfileId().equals(profileId)) {
                result.add(packageItem);
            }
        }

        return result;
    }

    @Override
    public void updatePackage(ProfilePackages profilePackage) {
        for (int i = 0; i < profilePackages.size(); i++) {
            if (profilePackages.get(i).getPackageId().equals(profilePackage.getPackageId())) {
                profilePackages.set(i, profilePackage);
                return;
            }
        }
        throw new IllegalArgumentException("Package with ID " + profilePackage.getPackageId() + " not found.");
    }


    @Override
    public void deletePackageById(Long packageId) {
        profilePackages.removeIf(packageItem -> packageItem.getPackageId().equals(packageId));
    }




    @Override
    public ProfilePackages searchByPackageId(Long packageId) {
        for (ProfilePackages packageItem : profilePackages) {
            if (packageItem.getPackageId().equals(packageId)) {
                return packageItem;
            }
        }
        return null;

    }

    @Override
    public ProfilePackages searchByPackageName(String packageName) {
        for (ProfilePackages packageItem : profilePackages) {
            if (packageItem.getPackageName().equalsIgnoreCase(packageName)) {
                return packageItem;
            }
        }
        return null;
    }
}

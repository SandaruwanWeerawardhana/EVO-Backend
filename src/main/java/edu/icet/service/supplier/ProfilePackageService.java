package edu.icet.service.supplier;

import edu.icet.dto.supplier.PackageFeature;
import edu.icet.dto.supplier.ProfilePackage;
import java.util.List;

public interface ProfilePackageService {

    ProfilePackage addPackage(ProfilePackage profilePackage);

    List<ProfilePackage> getAllPackages();

    List<ProfilePackage> getAllProfileById(Long profileId);

    ProfilePackage updatePackage(ProfilePackage profilePackage);

    Boolean deletePackageById(Long packageId);

    ProfilePackage searchByPackageId(Long packageId);

    ProfilePackage searchByPackageName(String packageName);
    ProfilePackage searchByPackageFeature(PackageFeature features);

}

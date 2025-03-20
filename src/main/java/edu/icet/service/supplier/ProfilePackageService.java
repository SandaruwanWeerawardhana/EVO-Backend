package edu.icet.service.supplier;

import edu.icet.dto.ProfilePackages;
import java.util.List;

public interface ProfilePackageService {

void addPackage(ProfilePackages profilePackages);

List<ProfilePackages>getAllPackages();

List<ProfilePackages>getAllProfileById(Long profileId);

void updatePackage(ProfilePackages profilePackages);

void deletePackageById(Long packageId);

ProfilePackages searchByPackageId(Long packageId);

ProfilePackages searchByPackageName(String packageName);

}

package edu.icet.service.supplier;

import edu.icet.dto.supplier.ProfilePackage;
import java.util.List;

public interface ProfilePackageService {

void addPackage(ProfilePackage profilePackage);

List<ProfilePackage>getAllPackages();

List<ProfilePackage>getAllProfileById(Long profileId);

void updatePackage(ProfilePackage profilePackage);

void deletePackageById(Long packageId);

ProfilePackage searchByPackageId(Long packageId);

ProfilePackage searchByPackageName(String packageName);

}

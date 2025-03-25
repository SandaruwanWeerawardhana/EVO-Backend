package edu.icet.controller.supplier;

import edu.icet.dto.supplier.ProfilePackages;
import edu.icet.service.supplier.ProfilePackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/venue/profile/package")
@RequiredArgsConstructor
@CrossOrigin
public class ProfilePackageController {

    final ProfilePackageService profilePackageService;

    @PostMapping("/add")
    public ProfilePackages add(@RequestBody ProfilePackages profilePackage) {
        profilePackageService.addPackage(profilePackage);
        return profilePackage;
    }

    @GetMapping("/getAll")
    public List<ProfilePackages> getAll() {
        return profilePackageService.getAllPackages();
    }

    @GetMapping("/getByProfile/{profileId}")
    public List<ProfilePackages> getAllByProfileId(@PathVariable Long profileId) {
        return profilePackageService.getAllProfileById(profileId);
    }

    @PutMapping("/update")
    public boolean updatePackage(@RequestBody ProfilePackages profilePackage) {
        profilePackageService.updatePackage(profilePackage);
        return true;
    }

    @DeleteMapping("/delete/{packageId}")
    public boolean deletePackage(@PathVariable Long packageId) {
        profilePackageService.deletePackageById(packageId);
        return true;
    }

    @GetMapping("/get/{packageId}")
    public ProfilePackages getById(@PathVariable Long packageId) {
        return profilePackageService.searchByPackageId(packageId);
    }

    @GetMapping("/getByName/{packageName}")
    public ProfilePackages getByName(@PathVariable String packageName) {
        return profilePackageService.searchByPackageName(packageName);
    }
}

package edu.icet.controller.supplier;

import edu.icet.dto.customer.User;
import edu.icet.dto.supplier.*;
import edu.icet.service.supplier.SupplierService;
import edu.icet.util.MealType;
import edu.icet.util.SupplierCategoryType;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService service;

    // Supplier endpoints

    @GetMapping("/users")
    @Operation(summary = "Returns user objects of all the suppliers")
//    @JsonView(JsonAPIViews.SupplierView.class)
    public ResponseEntity<List<User>> getAllUserSuppliers() {

        List<User> suppliers = service.getAllSupplierUsers();

        return suppliers.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(suppliers);
    }

    @GetMapping
    @Operation(summary = "Returns supplier objects of all the suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers(@RequestParam(required = false) SupplierCategoryType category) {
        List<Supplier> suppliers = category == null
                ? service.getAllSuppliers()
                : service.getSupplierByCategory(category);


        return suppliers.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(suppliers);
    }

    @PostMapping
    @Operation(summary = "Creates a supplier user")
    public ResponseEntity<User> addSupplierUser(@RequestBody User user) {
        return ResponseEntity.ok(service.addSupplierUser(user));
    }

    @GetMapping("/{supplierID}")
    @Operation(summary = "Returns a supplier based on ID")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long supplierID) {
        return ResponseEntity.ok(service.searchSupplier(supplierID));
    }

    @PutMapping
    public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(service.updateSupplier(supplier));
    }

    @DeleteMapping("/{supplierID}")
    public ResponseEntity<Boolean> deleteSupplier(@PathVariable Long supplierID) {
        return ResponseEntity.ok(service.deleteSupplier(supplierID));
    }


    // BeautySalon endpoints

    @GetMapping("/beauty-salon")
    public ResponseEntity<List<BeautySaloon>> getAllBeautySalon() {
        return ResponseEntity.ok(service.getAllBeautySalon());
    }

    @GetMapping("/beauty-salon/{beautySalonID}")
    public ResponseEntity<BeautySaloon> getBeautySalon(@PathVariable Long beautySalonID) {
        return ResponseEntity.ok(service.getBeautySalon(beautySalonID));
    }

    @PostMapping("/{supplierID}/beauty-salon")
    public ResponseEntity<Supplier> addBeautySalonSupplier(@RequestBody BeautySaloon beautySaloon, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addBeautySalonSupplier(beautySaloon, supplierID));
    }

    @PutMapping("/{supplierID}/beauty-salon")
    public ResponseEntity<Supplier> updateBeautySalonSupplier(@RequestBody BeautySaloon beautySaloon, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateBeautySalonSupplier(beautySaloon, supplierID));
    }

    @DeleteMapping("/{supplierID}/beauty-salon")
    public ResponseEntity<Boolean> deleteBeautySalonSupplier(@PathVariable Long supplierID) {
        return ResponseEntity.ok(service.deleteBeautySalonSupplier(supplierID));
    }


    // Catering endpoints

    @GetMapping("/catering")
    public ResponseEntity<List<Catering>> getAllCatering() {
        return ResponseEntity.ok(service.getAllCatering());
    }

    @GetMapping("/catering/{cateringID}")
    public ResponseEntity<Catering> getCateringByID(@PathVariable Long cateringID) {
        return ResponseEntity.ok(service.getCateringById(cateringID));
    }

    @PostMapping("/{supplierID}/catering")
    public ResponseEntity<Supplier> addCateringSupplier(@RequestBody Catering catering, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addCateringSupplier(catering, supplierID));
    }

    @PutMapping("/{supplierID}/catering")
    public ResponseEntity<Supplier> updateCateringSupplier(@RequestBody Catering catering, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateCateringSupplier(catering, supplierID));
    }

    @DeleteMapping("/{supplierID}/catering")
    public ResponseEntity<Boolean> deleteCateringSupplier(@PathVariable Long supplierID) {
        return ResponseEntity.ok(service.deleteCateringSupplier(supplierID));
    }


    // Music endpoints

    @GetMapping("/music")
    public ResponseEntity<List<Music>> getAllMusic() {
        return ResponseEntity.ok(service.getAllMusic());
    }

    @GetMapping("/music/{musicID}")
    public ResponseEntity<Music> getMusicByID(@PathVariable Long musicID) {
        return ResponseEntity.ok(service.getMusicByID(musicID));
    }

    @PostMapping("/{supplierID}/music")
    public ResponseEntity<Supplier> addMusicSupplier(@RequestBody Music music, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addMusicSupplier(music, supplierID));
    }

    @PutMapping("/{supplierID}/music")
    public ResponseEntity<Supplier> updateMusicSupplier(@RequestBody Music music, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateMusicSupplier(music, supplierID));
    }

    @DeleteMapping("/{supplierID}/music")
    public ResponseEntity<Boolean> deleteMusicSupplier(@PathVariable Long supplierID) {
        return ResponseEntity.ok(service.deleteMusicSupplier(supplierID));
    }


    // Meal

    @GetMapping("/meal")
    public ResponseEntity<List<Meal>> getAllMeals() {
        return ResponseEntity.ok(service.getAllCateringMeals());
    }

    @GetMapping("/meal/{mealID}")
    public ResponseEntity<Meal> getMealByID(@PathVariable Long mealID) {
        return ResponseEntity.ok(service.searchMealByID(mealID));
    }

    @GetMapping("/meal/catering/search")
    public ResponseEntity<List<Catering>> searchCateringByMeal(@RequestParam(required = false) MealType mealType, @RequestParam(required = false) String name) {
        List<Catering> cateringList;
        if (mealType != null) {
            cateringList = service.searchCateringByMealType(mealType);

        } else {
            if (name != null) cateringList = service.searchCateringByMealName(name);
            else cateringList = service.getAllCatering();
        }

        return ResponseEntity.ok(cateringList);

    }

    @PostMapping("/{cateringID}/meal")
    public ResponseEntity<Catering> addCateringMeal (@RequestBody Meal meal, @PathVariable Long cateringID) {
        return ResponseEntity.ok(service.addCateringMeal(meal, cateringID));
    }

    @PutMapping("/{cateringID}/meal")
    public ResponseEntity<Catering> updateCateringMeal(@RequestBody Meal meal, @PathVariable Long cateringID) {
        return ResponseEntity.ok(service.updateCateringMeal(meal, cateringID));
    }

    @DeleteMapping("/meal/{mealID}")
    public ResponseEntity<Boolean> deleteCateringMeal(@PathVariable Long mealID) {
        return ResponseEntity.ok(service.deleteCateringMeal(mealID));
    }


    // Inventory Endpoints

    @GetMapping("/inventory")
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(service.getAllInventory());
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> getInventoryByID(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchInventoryByID(id));
    }

    @PostMapping("/{supplierID}/inventory")
    public ResponseEntity<Supplier> addInventory(@RequestBody Inventory inventory, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addInventory(inventory, supplierID));
    }

    @PutMapping("/{supplierID}/inventory")
    public ResponseEntity<Supplier> updateInventory(@RequestBody Inventory inventory, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateInventory(inventory, supplierID));
    }

    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<Boolean> deleteInventory(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteInventory(id));
    }

    // ProfilePackage Endpoints
    @GetMapping("/profile-package")
    public ResponseEntity<List<ProfilePackage>> getAllProfilePackages() {
        return ResponseEntity.ok(service.getAllProfilePackages());
    }

    @PostMapping("/{supplierID}/profile-package")
    public ResponseEntity<Supplier> addProfilePackage(@RequestBody ProfilePackage profilePackage, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addProfilePackage(profilePackage, supplierID));
    }

    @PutMapping("/{supplierID}/profile-package")
    public ResponseEntity<Supplier> updateProfilePackage(@RequestBody ProfilePackage profilePackage, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateProfilePackage(profilePackage, supplierID));
    }

    @DeleteMapping("/profile-package/{packageId}")
    public ResponseEntity<Boolean> deleteProfilePackage(@PathVariable Long packageId) {
        return ResponseEntity.ok(service.deleteProfilePackage(packageId));
    }

    @GetMapping("/profile-package/{packageId}")
    public ResponseEntity<Supplier> getProfilePackageSupplierByID(@PathVariable Long packageId) {
        return ResponseEntity.ok(service.searchProfilePackageSupplierByID(packageId));
    }

    @GetMapping("/profile-package/search")
    public ResponseEntity<Supplier> searchProfilePackageByName(@RequestParam String packageName) {
        return ResponseEntity.ok(service.searchProfilePackageSupplierByName(packageName));
    }

    // PackageFeature Endpoints
    @GetMapping("/package-feature")
    public ResponseEntity<List<PackageFeature>> getAllPackageFeatures() {
        return ResponseEntity.ok(service.getAllPackageFeatures());
    }

    @PostMapping("/{packageID}/package-feature")
    public ResponseEntity<ProfilePackage> addPackageFeature(@RequestBody PackageFeature packageFeature, @PathVariable Long packageID) {
        return ResponseEntity.ok(service.addPackageFeature(packageFeature, packageID));
    }

    @PutMapping("/{packageID}/package-feature")
    public ResponseEntity<ProfilePackage> updatePackageFeature(@RequestBody PackageFeature packageFeature, @PathVariable Long packageID) {
        return ResponseEntity.ok(service.updatePackageFeature(packageFeature, packageID));
    }

    @DeleteMapping("/package-feature/{id}")
    public ResponseEntity<Boolean> deletePackageFeature(@PathVariable Long id) {
        return ResponseEntity.ok(service.deletePackageFeature(id));
    }

    @GetMapping("/package-feature/{id}")
    public ResponseEntity<ProfilePackage> searchPackageFeatureById(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchPackageFeatureById(id));
    }

    // ProfilePreviousWork Endpoints
    @GetMapping("/profile-previous-work")
    public ResponseEntity<List<ProfilePreviousWork>> getAllProfilePreviousWork() {
        return ResponseEntity.ok(service.getAllProfilePreviousWork());
    }

    @PostMapping("/{supplierID}/profile-previous-work")
    public ResponseEntity<Supplier> addProfilePreviousWork(@RequestBody ProfilePreviousWork profilePreviousWork, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addProfilePreviousWork(profilePreviousWork, supplierID));
    }

    @PutMapping("/{supplierID}/profile-previous-work")
    public ResponseEntity<Supplier> updateProfilePreviousWork(@RequestBody ProfilePreviousWork profilePreviousWork, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateProfilePreviousWork(profilePreviousWork, supplierID));
    }

    @DeleteMapping("/profile-previous-work/{id}")
    public ResponseEntity<Boolean> deleteProfilePreviousWork(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteProfilePreviousWork(id));
    }

    @GetMapping("/profile-previous-work/{id}")
    public ResponseEntity<ProfilePreviousWork> searchProfilePreviousWorkByID(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchProfilePreviousWorkByID(id));
    }

    // ProfileImage Endpoints
    @PostMapping("/{supplierID}/profile-image")
    public ResponseEntity<Supplier> addProfileImage(@RequestBody ProfileImage profileImage, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.addProfileImage(profileImage, supplierID));
    }

    @PutMapping("/{supplierID}/profile-image")
    public ResponseEntity<Supplier> updateProfileImage(@RequestBody ProfileImage profileImage, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.updateProfileImage(profileImage, supplierID));
    }

    @PostMapping("/{supplierID}/profile-image/profile-picture")
    public ResponseEntity<Supplier> changeProfilePicture(@RequestBody ProfileImage image, @PathVariable Long supplierID) {
        return ResponseEntity.ok(service.changeProfilePicture(image, supplierID));
    }

    @GetMapping("/profile-image/{id}")
    public ResponseEntity<ProfileImage> getProfileImageByID(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProfileImageByID(id));
    }

    @DeleteMapping("/profile-image/{id}")
    public ResponseEntity<Boolean> deleteProfileImage(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteProfileImage(id));
    }



}

package edu.icet.service.supplier;

import edu.icet.dto.customer.User;
import edu.icet.dto.supplier.*;
import edu.icet.util.MealType;
import edu.icet.util.SupplierCategoryType;

import java.util.List;

public interface SupplierManager {

    // Supplier-user
    User addSupplierUser(User user);
    List<User> getAllSupplierUsers();

    // Supplier
    List<Supplier> getAllSuppliers();
    List<Supplier> getSupplierByCategory(SupplierCategoryType category);
    Supplier searchSupplier(Long id);
    Supplier updateSupplier(Supplier supplier);
    Boolean deleteSupplier(Long supplerID);

    // BeautySalon
    List<BeautySaloon> getAllBeautySalon();
    Supplier addBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID);
    Boolean deleteBeautySalonSupplier(Long supplierID);
    Supplier updateBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID);
    BeautySaloon getBeautySalon(Long salonID);

    // Catering
    Supplier addCateringSupplier(Catering catering, Long supplierID);
    Supplier updateCateringSupplier(Catering catering, Long supplierID);
    Catering getCateringById(Long cateringID);
    List<Catering> getAllCatering();
    Boolean deleteCateringSupplier(Long supplierID);

    // Music
    List<Music> getAllMusic();
    Supplier addMusicSupplier(Music music, Long supplierID);
    Music getMusicByID(Long musicID);
    Supplier updateMusicSupplier(Music music, Long supplierID);
    Boolean deleteMusicSupplier(Long supplierID);

    // Meal
    List<Meal> getAllCateringMeals();
    Catering addCateringMeal(Meal meal, Long cateringID);
    Boolean deleteCateringMeal(Long id);
    Catering updateCateringMeal(Meal meal, Long cateringID);
    List<Catering> searchCateringByMealType(MealType type);
    List<Catering> searchCateringByMealName(String name);
    Meal searchMealByID(Long id);

    // Inventory
    List<Inventory> getAllInventory();
    Supplier addInventory(Inventory inventory, Long supplierID);
    Inventory searchInventoryByID(Long id);
    Supplier updateInventory(Inventory inventory, Long supplierID);
    Boolean deleteInventory(Long id);

    // ProfilePackage
    Supplier addProfilePackage(ProfilePackage profilePackage, Long supplierID);
    List<ProfilePackage> getAllProfilePackages();
    Supplier updateProfilePackage(ProfilePackage profilePackage, Long supplierID);
    Boolean deleteProfilePackage(Long packageId);
    Supplier searchProfilePackageSupplierByID(Long packageId);
    Supplier searchProfilePackageSupplierByName(String packageName);

    // PackageFeature
    List<PackageFeature> getAllPackageFeatures();
    ProfilePackage addPackageFeature(PackageFeature packageFeature, Long packageID);
    Boolean deletePackageFeature(Long id);
    ProfilePackage updatePackageFeature(PackageFeature packageFeature, Long packageID);
    ProfilePackage searchPackageFeatureById(Long id);

    // ProfilePreviousWork
    List<ProfilePreviousWork> getAllProfilePreviousWork();
    Supplier addProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID);
    Boolean deleteProfilePreviousWork(Long id);
    ProfilePreviousWork searchProfilePreviousWorkByID(Long profilePreviousWorkID);
    Supplier updateProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID);

    // ProfileImage
    Supplier changeProfilePicture(ProfileImage image, Long supplierID);
    Supplier addProfileImage(ProfileImage profileImage, Long supplierID);
    Supplier updateProfileImage(ProfileImage profileImage, Long supplierID);
    ProfileImage getProfileImageByID(Long profileImageID);
    Boolean deleteProfileImage(Long profileImageID);

    // SupplierRequest
    Supplier addSupplierRequest(SupplierRequest supplierRequest, Long supplierID);
    List<SupplierRequest> getAllSupplierRequests();
    SupplierRequest getSupplierRequestByID(Long id);
    Supplier updateSupplierRequest(SupplierRequest supplierRequest, Long supplierID);
    Boolean deleteSupplierRequest(Long id);

}

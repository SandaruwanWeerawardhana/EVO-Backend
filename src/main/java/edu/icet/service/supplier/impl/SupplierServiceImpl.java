package edu.icet.service.supplier.impl;

import edu.icet.dto.customer.User;
import edu.icet.dto.supplier.*;
import edu.icet.entity.customer.UserEntity;
import edu.icet.entity.event.BeautySaloonEntity;
import edu.icet.entity.supplier.*;
import edu.icet.repository.customer.UserRepository;
import edu.icet.repository.supplier.SupplierRepository;
import edu.icet.service.supplier.*;
import edu.icet.service.system.UserService;
import edu.icet.util.MealType;
import edu.icet.util.SupplierCategoryType;
import edu.icet.util.UserType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    final ModelMapper mapper;
    final SupplierRepository supplierRepository;
    final UserRepository userRepository;
    final UserService userService;
    final BeautySaloonService beautySaloonService;
    final CateringService cateringService;
    final MusicService musicService;
    final MealService mealService;
    final InventoryService inventoryService;
    final ProfilePackageService profilePackageService;
    final PackageFeatureService packageFeatureService;
    final ProfilePreviousWorkService profilePreviousWorkService;
    final ProfileImageService imageService;


    @Override
    public List<User> getAllSupplierUsers() {
        return userService
                .getAllUsers()
                .stream()
                .filter(user -> user.getUserType() == UserType.SUPPLIER)
                .toList();
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository
                .findAll()
                .stream()
                .map(supplier -> mapper.map(supplier, Supplier.class))
                .toList();
    }

    @Override
    public List<Supplier> getSupplierByCategory(SupplierCategoryType category) {
        return getAllSuppliers().stream().filter(supplier -> supplier.getCategory() == category).toList();
    }

    @Override
    public User addSupplierUser(User user) {
        UserEntity existingUser = userRepository.findById(user.getUserId()).orElse(null);

        if (existingUser != null && user.getSupplier() != null) {

            Supplier supplier = user.getSupplier();

            if (supplierRepository.existsByBusinessEmail(supplier.getBusinessEmail())) {
                throw new IllegalArgumentException("Email is already exits");
            }

            if (supplierRepository.existsByBusinessContactNumber(supplier.getBusinessContactNumber())) {
                throw new IllegalArgumentException("phone number is already exists");
            }

            if (supplierRepository.existsByBusinessName(supplier.getBusinessName())) {
                throw new IllegalArgumentException("Business name is already exists");
            }

            userService.updateUser(existingUser.getUserId(), mapper.map(existingUser, User.class));
            return mapper.map(existingUser, User.class);

        }

        userService.saveUser(user);

        return user;

    }

    @Override
    public Supplier searchSupplier(Long id) {
        SupplierEntity supplierEntity = supplierRepository.findById(id).orElse(null);

        return supplierEntity != null ? mapper.map(supplierEntity, Supplier.class) : null;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (supplierRepository.existsById(supplier.getId())) {
            return mapper.map(supplierRepository.save(mapper.map(supplier, SupplierEntity.class)), Supplier.class);

        }

        throw new IllegalArgumentException("Supplier does not exist!");
    }

    public Supplier updateSupplier(SupplierEntity supplierEntity) {
        return updateSupplier(mapper.map(supplierEntity, Supplier.class));
    }

    @Override
    public Boolean deleteSupplier(Long supplierID) {
        if (supplierRepository.existsById(supplierID)) {

            UserEntity userEntity = userRepository.findBySupplier(supplierRepository.findById(supplierID).orElse(null));
            userRepository.deleteById(userEntity.getUserId());

            supplierRepository.deleteById(supplierID);

            return true;
        }

        throw new IllegalArgumentException("Supplier does not exist!");

    }

    @Override
    public List<BeautySaloon> getAllBeautySalon() {
        return beautySaloonService.getAll();
    }

    @Override
    public Supplier addBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        BeautySaloon saloon = beautySaloonService.add(beautySaloon);
        supplier.setBeautySaloon(mapper.map(saloon, BeautySaloonEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Boolean deleteBeautySalonSupplier(Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        beautySaloonService.delete(supplier.getBeautySaloon().getId());
        return deleteSupplier(supplier.getId());
    }

    @Override
    public Supplier updateBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        BeautySaloon saloon = beautySaloonService.update(beautySaloon);
        supplier.setBeautySaloon(mapper.map(saloon, BeautySaloonEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public BeautySaloon getBeautySalon(Long salonID) {
        return beautySaloonService.get(salonID);
    }

    @Override
    public Supplier addCateringSupplier(Catering catering, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        Catering addCatering = cateringService.addCatering(catering);
        supplier.setCatering(mapper.map(addCatering, CateringEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Supplier updateCateringSupplier(Catering catering, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        Catering updateCatering = cateringService.updateCatering(catering);
        supplier.setCatering(mapper.map(updateCatering, CateringEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Catering getCateringById(Long cateringID) {
        return cateringService.getCateringById(cateringID).orElse(null);
    }

    @Override
    public List<Catering> getAllCatering() {
        return cateringService.getAllCatering();
    }

    @Override
    public Boolean deleteCateringSupplier(Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        cateringService.deleteCatering(supplier.getCatering().getCateringId());
        return deleteSupplier(supplier.getId());
    }

    @Override
    public List<Music> getAllMusic() {
        return musicService.getAll();
    }

    @Override
    public Supplier addMusicSupplier(Music music, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        musicService.addMusic(music);
        supplier.setMusic(mapper.map(music, MusicEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Music getMusicByID(Long musicID) {
        return musicService.searchMusic(musicID);
    }

    @Override
    public Supplier updateMusicSupplier(Music music, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        Music updateMusic = musicService.updateMusic(music);
        supplier.setMusic(mapper.map(updateMusic, MusicEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Boolean deleteMusicSupplier(Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        musicService.deleteMusic(supplier.getMusic().getMusicID());
        return deleteSupplier(supplier.getId());
    }

    @Override
    public List<Meal> getAllCateringMeals() {
        return mealService.getAll();
    }

    @Override
    public Catering addCateringMeal(Meal meal, Long cateringID) {
        Catering catering = findCatering(cateringID);

        Meal save = mealService.save(meal);
        catering.getMeals().add(save);

        return cateringService.updateCatering(catering);
    }

    @Override
    public Boolean deleteCateringMeal(Long id) {
        return mealService.delete(id);
    }

    @Override
    public Catering updateCateringMeal(Meal meal, Long cateringID) {

        mealService.update(meal);

        return findCatering(cateringID); // With updated meal
    }

    @Override
    public List<Catering> searchCateringByMealType(MealType type) {
        List<Meal> meals = mealService.search(type);
        return cateringService.getCateringWIthMeals(meals);
    }

    @Override
    public List<Catering> searchCateringByMealName(String name) {
        List<Meal> meals = mealService.search(name);
        return cateringService.getCateringWIthMeals(meals);
    }

    @Override
    public Meal searchMealByID(Long id) {
        return mealService.search(id);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryService.getAll();
    }

    @Override
    public Supplier addInventory(Inventory inventory, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        inventoryService.add(inventory);
        supplier.getInventories().add(mapper.map(inventory, InventoryEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Inventory searchInventoryByID(Long id) {
        return inventoryService.search(id);
    }

    @Override
    public Supplier updateInventory(Inventory inventory, Long supplierID) {

        inventoryService.update(inventory);
        return mapper.map(findSupplier(supplierID), Supplier.class);
    }

    @Override
    public Boolean deleteInventory(Long id) {
        return inventoryService.delete(id);
    }

    @Override
    public Supplier addProfilePackage(ProfilePackage profilePackage, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        ProfilePackage addPackage = profilePackageService.addPackage(profilePackage);
        supplier.getPackages().add(mapper.map(addPackage, ProfilePackageEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public List<ProfilePackage> getAllProfilePackages() {
        return profilePackageService.getAllPackages();
    }

    @Override
    public Supplier updateProfilePackage(ProfilePackage profilePackage, Long supplierID) {

        profilePackageService.updatePackage(profilePackage);

        return mapper.map(findSupplier(supplierID), Supplier.class);
    }

    @Override
    public Boolean deleteProfilePackage(Long packageId) {
        return profilePackageService.deletePackageById(packageId);
    }

    @Override
    public Supplier searchProfilePackageSupplierByID(Long packageId) {
        ProfilePackage profilePackage = profilePackageService.searchByPackageId(packageId);

        return mapper.map(
                supplierRepository.findByPackagesIn(
                            List.of(mapper.map(profilePackage, ProfilePackageEntity.class))
                ), Supplier.class);

    }

    @Override
    public Supplier searchProfilePackageSupplierByName(String packageName) {
        ProfilePackage profilePackage = profilePackageService.searchByPackageName(packageName);

        return mapper.map(
                supplierRepository.findByPackagesIn(
                        List.of(mapper.map(profilePackage, ProfilePackageEntity.class))
                ), Supplier.class);
    }

    @Override
    public List<PackageFeature> getAllPackageFeatures() {
        return packageFeatureService.getAll();
    }

    @Override
    public ProfilePackage addPackageFeature(PackageFeature packageFeature, Long packageID) {
        ProfilePackage profilePackage = findProfilePackage(packageID);

        PackageFeature feature = packageFeatureService.save(packageFeature);
        profilePackage.getFeatures().add(feature);

        return profilePackageService.updatePackage(profilePackage);
    }

    @Override
    public Boolean deletePackageFeature(Long id) {
        return packageFeatureService.delete(id);
    }

    @Override
    public ProfilePackage updatePackageFeature(PackageFeature packageFeature, Long packageID) {

        packageFeatureService.update(packageFeature);

        return findProfilePackage(packageID);
    }

    @Override
    public ProfilePackage searchPackageFeatureById(Long id) {
        PackageFeature packageFeature = packageFeatureService.searchById(id);
        return profilePackageService.searchByPackageFeature(packageFeature);
    }

    @Override
    public List<ProfilePreviousWork> getAllProfilePreviousWork() {
        return profilePreviousWorkService.getAll();
    }

    @Override
    public Supplier addProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        ProfilePreviousWork previousWork = profilePreviousWorkService.save(profilePreviousWork);
        supplier.getPreviousWorks().add(mapper.map(previousWork, ProfilePreviousWorkEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Boolean deleteProfilePreviousWork(Long id) {
        return profilePreviousWorkService.delete(id);
    }

    @Override
    public ProfilePreviousWork searchProfilePreviousWorkByID(Long profilePreviousWorkID) {
        return profilePreviousWorkService.search(profilePreviousWorkID);
    }

    @Override
    public Supplier updateProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID) {

        profilePreviousWorkService.update(profilePreviousWork);

        return mapper.map(findSupplier(supplierID), Supplier.class);
    }

    @Override
    public Supplier changeProfilePicture(ProfileImage image, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        if (supplier.getProfileImage() != null) {
            imageService.deleteProfileImage(supplier.getProfileImage().getId()); // Deleting old profile image
        }

        ProfileImage profileImage = imageService.addProfileImage(image);
        supplier.setProfileImage(mapper.map(profileImage, ProfileImageEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Supplier addProfileImage(ProfileImage profileImage, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);

        ProfileImage image = imageService.addProfileImage(profileImage);
        supplier.getImages().add(mapper.map(image, ProfileImageEntity.class));

        return updateSupplier(supplier);
    }

    @Override
    public Supplier updateProfileImage(ProfileImage profileImage, Long supplierID) {

        imageService.updateProfileImage(profileImage);

        return mapper.map(findSupplier(supplierID), Supplier.class);
    }

    @Override
    public ProfileImage getProfileImageByID(Long profileImageID) {
        return imageService.getProfileImage(profileImageID);
    }

    @Override
    public Boolean deleteProfileImage(Long profileImageID) {
        return imageService.deleteProfileImage(profileImageID);
    }


    private SupplierEntity findSupplier(Long supplierID) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplierID).orElse(null);

        if (supplierEntity == null)
            throw new IllegalArgumentException("Supplier does not exist! Please create a supplier first!");

        return supplierEntity;
    }

    private Catering findCatering(Long cateringID) {
        Catering catering = cateringService.getCateringById(cateringID).orElse(null);

        if (catering == null)
            throw new IllegalArgumentException("Catering does not exist! Please create a catering first!");

        return catering;
    }

    private ProfilePackage findProfilePackage(Long packageID) {
        ProfilePackage profilePackage = profilePackageService.searchByPackageId(packageID);

        if (profilePackage == null)
            throw new IllegalArgumentException("Profile Package does not exist! Please create a Profile Package first!");

        return profilePackage;
    }

}

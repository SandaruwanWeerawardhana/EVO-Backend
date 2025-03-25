package edu.icet.controller.supplier;

import edu.icet.dto.supplier.*;

import edu.icet.dto.system.Profile;
import edu.icet.service.supplier.*;
import edu.icet.service.system.ProfileImageService;
import edu.icet.service.system.ProfilePreviousWorkImageService;
import edu.icet.service.system.ProfileService;
import edu.icet.util.MealType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor

public class SupplierController {

    private final SupplierService supplierService;
    private final BeautyPackageService beautyPackageService;
    private final BeautySaloonService service;
    private final BookingSlotService bookingSlotService;
    private final CateringService cateringService;
    private final InventoryService inventoryService;
    private final MealService mealService;
    private final MusicService musicService;
    private final MusicPackageService musicPackageService;
    private final PackageFeatureDetailService featureDetailService;
    private final PhotographerImageService photographerImageService;
    private final PhotographerPackageService photographerPackageService;
    private final ProfileService profileService;
    private final ProfileExtraFeatureService profileExtraFeatureService;
    private final ProfileImageService profileImageService;
    private final ProfilePackageService profilePackageService;
    private final ProfilePreviousWorkService previousWorkService;
    private final ProfilePreviousWorkImageService profilePreviousWorkImageService;
    private final SalonImageService salonImageService;

    @PostMapping("/add-supplier")
    public void addSupplier(@RequestBody Supplier supplier){
        supplierService.add(supplier);
    }

    @GetMapping("/all-suppliers")
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAll();
    }

    @GetMapping("/search-supplier/{category}")
    public List<Supplier> getSupplierByCategory(@PathVariable String category){ return supplierService.getByCategory(category); }

    @GetMapping("/search-supplier")
    public void searchSupplier(@RequestBody Supplier query){ supplierService.search(query); }

    @DeleteMapping("/delete-supplier")
    public void deleteSupplier(@RequestParam Long id){
        supplierService.delete(id);
    }

    @PutMapping("/update-supplier")
    public void updateSupplier(@RequestBody Supplier supplier){
        supplierService.update(supplier);
    }

    @PostMapping("/beauty-packages/add-BeautyPackages")
    public BeautyPackage addBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        return beautyPackageService.save(beautyPackage);
    }

    @GetMapping("/beauty-packages/getAll-BeautyPackages")
    public List<BeautyPackage> getAllBeautyPackage(){
        return beautyPackageService.getAll();
    }

    @DeleteMapping("/beauty-packages/delete-BeautyPackages/{id}")
    public boolean deleteBeautyPackage(@PathVariable("id") Long id){
        return beautyPackageService.delete(id);
    }

    @PutMapping("/beauty-packages/update-BeautyPackages")
    public BeautyPackage updateBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        return beautyPackageService.update(beautyPackage);
    }

    @PostMapping("/beauty-saloon/add-beautySaloon")
    public void addBeautySaloon(@RequestBody BeautySaloon beautySaloon){
        service.add(beautySaloon);
    }
    @GetMapping("/get-allBeautySaloon")
    public List<BeautySaloon> getAllBeautySaloon(){
        return service.getAll();
    }
    @DeleteMapping("/beauty-saloon/delete-beautySaloon/{id}")
    public boolean deleteBeautySaloon(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/beauty-saloon/update-beautySaloon")
    public void updateBeautySaloon(@RequestBody BeautySaloon beautySaloon){
        service.update(beautySaloon);
    }

    @GetMapping("/beauty-saloon/get-id-beautySaloon/{id}")
    public BeautySaloon getIdBeautySaloon(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping("/addBookingSlot")
    public BookingSlot addBookingSlot(@RequestBody BookingSlot bookingSlot) {
        return bookingSlotService.save(bookingSlot);
    }

    @GetMapping("/getAllBookingSlot")
    public List<BookingSlot> getAllBookingSlot() {
        return bookingSlotService.getAll();
    }

    @DeleteMapping("/deleteBookingSlot/{id}")
    public boolean deleteBookingSlot(@PathVariable Long id) {
        return bookingSlotService.delete(id);
    }

    @PutMapping("/update-bookingSlot")
    public BookingSlot updateBookingSlot(@RequestBody BookingSlot bookingSlot){
        return bookingSlotService.update(bookingSlot);
    }

    @PostMapping("Catering/add-catering")
    public ResponseEntity<Catering> addCatering(@Valid @RequestBody Catering catering) {
        Catering createdCatering = cateringService.addCatering(catering);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCatering);
    }

    @PutMapping("Catering/update-catering")
    public ResponseEntity<Catering> updateCatering(@Valid @RequestBody Catering catering) {
        Catering updatedCatering = cateringService.updateCatering(catering);
        return ResponseEntity.ok(updatedCatering);
    }

    @GetMapping("Catering/get-catering/{id}")
    public ResponseEntity<Catering> getCateringById(@PathVariable Integer id) {
        return cateringService.getCateringById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("Catering/get-all-catering")
    public ResponseEntity<List<Catering>> getAllCatering() {
        List<Catering> cateringList = cateringService.getAllCatering();
        return ResponseEntity.ok(cateringList);
    }

    @DeleteMapping("Catering/delete-catering/{id}")
    public ResponseEntity<String> deleteCatering(@PathVariable Integer id) {
        cateringService.deleteCatering(id);
        return ResponseEntity.ok("Catering service deleted successfully.");
    }

    @GetMapping("Catering/Catering-supplier/{supplierId}")
    public ResponseEntity<List<Catering>> getCateringBySupplierId(@PathVariable Integer supplierId) {
        List<Catering> cateringList = cateringService.getCateringBySupplierId(supplierId);
        return ResponseEntity.ok(cateringList);
    }

    @PostMapping("/inventory/add-inventory")
    public boolean addInventory(@RequestBody Inventory inventory){
        return inventoryService.add(inventory);
    }

    @GetMapping("/inventory/get-all-inventories")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAll();
    }

    @GetMapping("/inventory/search-inventory/{id}")
    public List<Inventory> searchInventoryByName(@PathVariable("id") Long id){
        return inventoryService.search(id);
    }

    @DeleteMapping("/inventory/delete-inventory/{id}")
    public boolean deleteInventory(@PathVariable("id") Long id){
        return inventoryService.delete(id);
    }

    @PutMapping("/inventory/update-inventory")
    public boolean updateInventory(@RequestBody Inventory inventory){
        return inventoryService.update(inventory);
    }

    @GetMapping("/meal/get-all-meals")
    public List<Meal> getAllMeals(){
        return mealService.getAll();
    }

    @GetMapping("/meal/search-meal/{name}")
    public List<Meal> searchMealByName(@PathVariable("name") String name){
        return mealService.search(name);
    }

    @GetMapping("/meal/search-meal/{id}")
    public Meal searchMealById(@PathVariable("id") Long id){
        return mealService.search(id);
    }

    @GetMapping("/meal/search-meal/{type}")
    public List<Meal> searchMealByType(@PathVariable("type") MealType type){
        return mealService.search(type);
    }

    @PostMapping("/meal/save-meal")
    public Meal saveMeal(@RequestBody Meal meal){
        return mealService.save(meal);
    }

    @DeleteMapping("/meal/delete-meal")
    public Boolean deleteMeal(@RequestBody Meal meal){
        return mealService.delete(meal);
    }

    @DeleteMapping("/meal/delete-meal-by-id/{id}")
    public Boolean deleteMealById(@PathVariable("id") Long id){
        return mealService.delete(id);
    }

    @PutMapping("/meal/update-meal")
    public Meal updateMeal(@RequestBody Meal meal){
        return mealService.update(meal);
    }

    @PostMapping("/music/add-music")
    public void addMusic(@RequestBody Music music){
        musicService.addMusic(music);
    }

    @GetMapping("/music/get-all-music")
    public List<Music> getAllMusic(){
        return musicService.getAll(new Supplier());
    }

    @GetMapping("/music/search-music-by-id")
    public Music searchMusicById(@RequestParam Long id){
        return musicService.searchMusic(id);
    }

    @DeleteMapping("/music/delete-music")
    public void deleteMusic(@RequestParam Long id){
        musicService.deleteMusic(id);
    }

    @PutMapping("/music/update-music")
    public void updateMusic(@RequestBody Music music){
        musicService.updateMusic(music);
    }

    @PostMapping("/music/music-package/create-music-package")
    public boolean createMusicPackage(@RequestBody MusicPackage musicPackage) {
        return musicPackageService.create(musicPackage);
    }

    @GetMapping("/music/music-package/get-all-music-package")
    public List<MusicPackage> getAllMusicPackages() {
        return musicPackageService.getAll();
    }

    @PostMapping("/music/music-package/update-music-package")
    public boolean updateMusicPackage(@RequestBody MusicPackage musicPackage) {
        return musicPackageService.update(musicPackage);
    }

    @GetMapping("/music/music-package/get-music-package-by-id")
    public MusicPackage getMusicPackageById(@RequestParam(value = "id") Integer id) {
        return musicPackageService.getById(id);
    }

    @DeleteMapping("/music/music-package/delete-music-package")
    public MusicPackage deleteMusicPackageById(@RequestParam(value = "id") Integer id) {
        return musicPackageService.getById(id);
    }

    @GetMapping("/package/packageFeatureDetail/all-featureDetails")
    public List<PackageFeatureDetail> getAllFeatureDetails(){
        return featureDetailService.getAll();
    }

    @PostMapping("/package/packageFeatureDetail/add-featureDetail")
    public void addFeatureDetail(@RequestBody PackageFeatureDetail detail){featureDetailService.add(detail);}

    @GetMapping("/package/packageFeatureDetail/search-featureDetail")
    public PackageFeatureDetail searchFeatureDetail(@RequestBody PackageFeatureDetail query){return featureDetailService.search(query);}

    @PutMapping("/package/packageFeatureDetail/update-featureDetail")
    public void updateFeatureDetail(@RequestBody PackageFeatureDetail detail){featureDetailService.update(detail);}

    @DeleteMapping("/package/packageFeatureDetail/delete-featureDetail/{id}")
    public void deleteFeatureDetail(@PathVariable Long id){featureDetailService.delete(id);}

    @PostMapping("/photographer/image/add-photographerImage")
    public PhotographerImage addPhotographerImage(@RequestBody PhotographerImage photographerImage){
        return photographerImageService.save(photographerImage);
    }

    @GetMapping("/photographer/image/getAll-PhotographerImages")
    public List<PhotographerImage> getAllPhotographerImages(){
        return photographerImageService.getAll();
    }

    @DeleteMapping("/photographer/image/delete-photographerImage/{id}")
    public boolean deletePhotographerImage(@PathVariable("id") Long id){
        return  photographerImageService.delete(id);
    }

    @PutMapping("/photographer/image/update-photographerImage")
    public PhotographerImage updatePhotographerImage(@RequestBody PhotographerImage photographerImage){
        return photographerImageService.update(photographerImage);
    }

    @PostMapping("/photographer/package/add-photographerPackage")
    public PhotographerPackage addPhotographerPackage(@RequestBody PhotographerPackage photographerPackage){
        return photographerPackageService.save(photographerPackage);
    }

    @GetMapping("/photographer/package/getAll-photographerPackages")
    public List<PhotographerPackage> getAllPhotographerPackages(){
        return photographerPackageService.getAll();
    }

    @DeleteMapping("/photographer/package/delete-photographerPackage/{id}")
    public boolean deletePhotographerPackage(@PathVariable("id") Long id){
        return  photographerPackageService.delete(id);
    }

    @PutMapping("/photographer/package/update-photographerPackage")
    public PhotographerPackage updatePhotographerPackage(@RequestBody PhotographerPackage photographerPackage){
        return photographerPackageService.update(photographerPackage);
    }

    @PostMapping("/profiles/add-profile")
    public ResponseEntity<Profile> addProfile(@Valid @RequestBody Profile profile) {
        Profile createdProfile = profileService.addProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @PutMapping("/profiles/update-profile")
    public ResponseEntity<Profile> updateProfile(@Valid @RequestBody Profile profile) {
        Profile updatedProfile = profileService.updateProfile(profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/profiles/get-profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @GetMapping("/profiles/all-profiles")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @DeleteMapping("/profiles/delete-profile/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok("Profile deleted successfully.");
    }

    @PostMapping("/profile/profile-extra-feature/add-profileExtraFeature")
    public Boolean saveProfileExtraFeature(@RequestBody ProfileExtraFeature profileExtraFeature) {
        return profileExtraFeatureService.save(profileExtraFeature);
    }
    @DeleteMapping("/profile/profile-extra-feature/delete-profileExtraFeature/{id}")
    public boolean deleteProfileExtraFeature(@PathVariable Long id) {
        return profileExtraFeatureService.delete(id);
    }

    @PutMapping("/profile/profile-extra-feature/update-profileExtraFeature")
    public boolean updateProfileExtraFeature(@RequestBody Long id, ProfileExtraFeature profileExtraFeature) {
        return profileExtraFeatureService.update(id, profileExtraFeature);
    }

    @GetMapping("/profile/profile-extra-feature/getAll-profileExtraFeatures")
    public List<ProfileExtraFeature> getAllProfileExtraFeature() {
        return profileExtraFeatureService.getAll();
    }

    @GetMapping("/profile/profile-extra-feature/get-profileExtraFeature/{id}")
    public ProfileExtraFeature searchProfileExtraFeatureById(@PathVariable Long id) {
        return profileExtraFeatureService.searchById(id);
    }

    @PostMapping("/profile/profile-images/update-profile-image/{userId}")
    public ResponseEntity<String> updateProfileImage(@PathVariable Long userId,
                                                     @RequestParam("file") MultipartFile file) {
        try {
            ProfileImage profileImage = new ProfileImage();
            profileImage.setUserId(userId);
            profileImage.setProfileImage(file);

            profileImageService.updateProfileImage(profileImage);
            return ResponseEntity.ok("Profile image updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating profile image.");
        }
    }

    @GetMapping("/profile/profile-images/get-profile-image/{userId}")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable Integer userId) {
        Optional<ProfileImage> profileImageOpt = profileImageService.getProfileImageByUserId(userId);

        if (profileImageOpt.isPresent()) {
            try {
                ProfileImage profileImage = profileImageOpt.get();
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)  // Adjust based on file type
                        .body(profileImage.getProfileImage().getBytes());
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/profile/profile-images/delete-profile-image/{userId}")
    public ResponseEntity<String> deleteProfileImage(@PathVariable Integer userId) {
        profileImageService.deleteProfileImage(userId);
        return ResponseEntity.ok("Profile image deleted successfully.");
    }

    @PostMapping("/profile/package/add-package")
    public ProfilePackages addPackage(@RequestBody ProfilePackages profilePackage) {
        profilePackageService.addPackage(profilePackage);
        return profilePackage;
    }

    @GetMapping("/profile/package/getAll-packages")
    public List<ProfilePackages> getAllPackages() {
        return profilePackageService.getAllPackages();
    }

    @GetMapping("/profile/package/getAllPackagesByProfileId/{profileId}")
    public List<ProfilePackages> getAllPackagesByProfileId(@PathVariable Long profileId) {
        return profilePackageService.getAllProfileById(profileId);
    }

    @PutMapping("/profile/package/update-package")
    public boolean updatePackage(@RequestBody ProfilePackages profilePackage) {
        profilePackageService.updatePackage(profilePackage);
        return true;
    }

    @DeleteMapping("/profile/package/delete-package-by-id/{packageId}")
    public boolean deletePackage(@PathVariable Long packageId) {
        profilePackageService.deletePackageById(packageId);
        return true;
    }

    @GetMapping("/profile/package/get-package-by-id/{packageId}")
    public ProfilePackages getPackageById(@PathVariable Long packageId) {
        return profilePackageService.searchByPackageId(packageId);
    }

    @GetMapping("/profile/package/get-package-by-name/{packageName}")
    public ProfilePackages getByName(@PathVariable String packageName) {
        return profilePackageService.searchByPackageName(packageName);
    }

    @PostMapping("/profile/previous-work/save-previousWork")
    public void saveWork(@RequestBody ProfilePreviousWork previousWork){
        previousWorkService.save(previousWork);
    }

    @GetMapping("/profile/previous-work/get-all-previousWorks")
    public List<ProfilePreviousWork> getAllPreviousWorks(@RequestBody Profile profile){
        return previousWorkService.getAll(profile);
    }

    @PutMapping("/profile/previous-work/update-previousWork")
    public boolean updateProfile(@RequestBody ProfilePreviousWork previousWork){
        return previousWorkService.update(previousWork);
    }

    @DeleteMapping("/profile/previous-work/delete-previousWork-by-id")
    public boolean deleteProfileById(@RequestParam Long id){
        return previousWorkService.delete(id);
    }

    @GetMapping("/profile/previous-work/get-previous-work-by-id")
    public ProfilePreviousWork searchPreviousWork(@RequestParam ProfilePreviousWork profilePreviousWork){
        return previousWorkService.search(profilePreviousWork);
    }

    @PostMapping("/profile/previous-work-img/add-work-img")
    public ProfilePreviousWorkImage addPreviousWorkImage(@RequestBody ProfilePreviousWorkImage profilePreviousWorkImage) {
        return profilePreviousWorkImageService.addPreviousWorkImage(profilePreviousWorkImage);
    }

    @PutMapping("/profile/previous-work-img/update-work-img")
    public ProfilePreviousWorkImage updatePreviousWorkImage(@RequestBody ProfilePreviousWorkImage profilePreviousWorkImage) {
        return profilePreviousWorkImageService.updatePreviousWorkImage(profilePreviousWorkImage);
    }

    @GetMapping("/profile/previous-work-img/all-work-images")
    public List<ProfilePreviousWorkImage> getAllPreviousWorkImages() {
        return profilePreviousWorkImageService.getAllPreviousWorkImage();
    }

    @DeleteMapping("/profile/previous-work-img/delete-work-img/{id}")
    public void deletePreviousWorkImage(@PathVariable Long id) {
        profilePreviousWorkImageService.deleteByProfilePreviousWorkImageId(id);
    }

    @GetMapping("/profile/previous-work-img/search-work-img/{id}")
    public ProfilePreviousWorkImage searchPreviousWorkImage(@PathVariable Long id) {
        return profilePreviousWorkImageService.searchByProfilePreviousWorkImageId(id);
    }

    @PostMapping("/salon/images/add-image")
    public SalonImage addSalonImage(@RequestBody SalonImage salonImage){
        return salonImageService.save(salonImage);
    }

    @GetMapping("/salon/images/getAll-images")
    public List<SalonImage> getAllSalonImages(){
        return salonImageService.getAll();
    }

    @DeleteMapping("/salon/images/delete-image-by-id/{id}")
    public boolean deleteSalonImage(@PathVariable("id") Long id){
        return  salonImageService.delete(id);
    }

    @PutMapping("/salon/images/update-image")
    public SalonImage updateSalonImage(@RequestBody SalonImage salonImage){
        return  salonImageService.update(salonImage);
    }
}

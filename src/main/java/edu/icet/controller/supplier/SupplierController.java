package edu.icet.controller.supplier;

import edu.icet.dto.admin.VerificationRequest;
import edu.icet.dto.supplier.*;

import edu.icet.service.admin.VerificationRequestService;
import edu.icet.service.supplier.*;
import edu.icet.util.MealType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor

public class SupplierController {

    private final SupplierService supplierService;
    private final BeautySaloonService service;
    private final BookingSlotService bookingSlotService;
    private final CateringService cateringService;
    private final InventoryService inventoryService;
    private final MealService mealService;
    private final MusicService musicService;

    private final MusicPackageService musicPackageService;

    private final PhotographerPackageService photographerPackageService;
    private final ProfileExtraFeatureService profileExtraFeatureService;
    private final ProfilePackageService profilePackageService;
    private final ProfilePreviousWorkService previousWorkService;

    private final SalonImageService salonImageService;

    private VerificationRequestService verificationRequestService;

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

    @GetMapping("Catering/Catering-supplier/")
    public ResponseEntity<List<Catering>> getCateringBySupplierId(@RequestBody Supplier supplier) {
        List<Catering> cateringList = cateringService.getCateringBySupplierId(supplier);
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

    @PostMapping("/verification-request/add")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Boolean> saveVerificationRequest(@RequestBody VerificationRequest request) {
        boolean result = verificationRequestService.saveVerificationRequest(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/verification-request/find-by-id/{id}")
    ResponseEntity<VerificationRequest> findVerificationRequestById(@PathVariable Long id) {
        VerificationRequest verificationRequest = verificationRequestService.findVerificationrequestById(id);
        if (verificationRequest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(verificationRequest);
    }

    @GetMapping("/verification-request/get-all")
    ResponseEntity<List<VerificationRequest>> getAllVerificationRequest() {
        List<VerificationRequest> allVerificationRequest = verificationRequestService.getAllVerificationRequest();
        return ResponseEntity.ok(allVerificationRequest);
    }

    @DeleteMapping("/verification-request/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<Boolean> deleteVerificationRequest(@PathVariable Long id) {
        boolean result = verificationRequestService.deleteVerificationRequest(id);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PutMapping("/verification-request/update/{id}")
    ResponseEntity<Boolean> updateVerificationRequest(@PathVariable Long id, @RequestBody VerificationRequest request) {
        boolean result = verificationRequestService.updateVerificationRequest(id, request);
        return ResponseEntity.ok(result);
    }

}

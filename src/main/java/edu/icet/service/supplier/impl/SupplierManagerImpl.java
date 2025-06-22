package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.*;
import edu.icet.entity.customer.UserEntity;
import edu.icet.entity.event.BeautySaloonEntity;
import edu.icet.entity.supplier.*;
import edu.icet.repository.admin.SupplierRequestReporsitory;
import edu.icet.repository.customer.UserRepository;
import edu.icet.repository.supplier.*;
import edu.icet.service.supplier.SupplierManager;
import edu.icet.util.MealType;
import edu.icet.util.SupplierCategoryType;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierManagerImpl implements SupplierManager {
    final ModelMapper mapper;
    final SupplierRepository supplierRepository;
    final UserRepository userRepository;
    final ProfilePackageRepository profilePackageRepository;
    final CateringRepository cateringRepository;
    final SupplierRequestReporsitory requestReporsitory;
    final ProfilePreviousWorkRepository profilePreviousWorkRepository;
    final ImageGalleryRepository imageGalleryRepository;
    final InventoryRepository inventoryRepository;
    final BeautySaloonRepository beautySaloonRepository;
    final MusicRepository musicRepository;
    final MealRepository mealRepository;
    final SupplierExtraFeatureRepository supplierExtraFeatureRepository;
    private final ModelMapper modelMapper;
    final BCryptPasswordEncoder passwordEncoder;

    // Add Supplier
    @Override
    public Supplier addSupplier(Supplier supplier) {

        supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
        SupplierEntity supplierEntity = supplierRepository.save(mapper.map(supplier, SupplierEntity.class));

        return mapper.map(supplierEntity, Supplier.class);
    }

    // Get all supplier
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository
                .findAll()
                .stream()
                .map(supplier -> mapper.map(supplier, Supplier.class))
                .toList();
    }

    // Get supplier by category
    @Override
    public List<Supplier> getSupplierByCategory(SupplierCategoryType supplierCategoryType) {
        return getAllSuppliers()
                .stream()
                .filter(supplier -> supplier.getCategory() == supplierCategoryType).toList();
    }

    // Search supplier
    @Override
    public Supplier searchSupplier(Long supplerID) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplerID).orElse(null);

        return supplierEntity != null ? mapper.map(supplierEntity, Supplier.class) : null;
    }

    // Update supplier
    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (supplierRepository.existsById(supplier.getId())) {
            return mapper.map(supplierRepository.save(mapper.map(supplier, SupplierEntity.class)), Supplier.class);

        }

        throw new IllegalArgumentException("Supplier does not exist!");
    }

    // Delete supplier
    @Override
    public Boolean deleteSupplier(Long supplerID) {
        if (supplierRepository.existsById(supplerID)) {

            UserEntity userEntity = userRepository.findBySupplier(supplierRepository.findById(supplerID).orElse(null));
            userRepository.deleteById(userEntity.getUserId());

            supplierRepository.deleteById(supplerID);

            return true;
        }

        throw new IllegalArgumentException("Supplier does not exist!");
    }


    @Override
    @Transactional
    public AllSupplierDetails addSupplierWithDetails(AllSupplierDetails details) {
        SupplierEntity supplier = handleSupplier(details.getSupplier());

        if (supplier.getId() != null) {
            // Delete existing packages and image gallery
            List<ProfilePackageEntity> packages = profilePackageRepository.findBySupplierId(supplier.getId());
            profilePackageRepository.deleteAll(packages);

            // Delete existing image gallery
            imageGalleryRepository.findBySupplierID(supplier.getId())
                    .ifPresent(imageGalleryRepository::delete);
        }

        // Save packages and features
        List<ProfilePackage> savedPackages = savePackages(details.getPackages(), supplier);
        List<PackageFeature> savedFeatures = saveExtraFeatures(details.getExtraFeatures(), supplier);

        // Save image gallery
        ImageGallery savedImageGallery = saveImageGallery(details.getImageGallery(), supplier.getId());

        return AllSupplierDetails.builder()
                .supplier(mapper.map(supplier, Supplier.class))
                .packages(savedPackages)
                .extraFeatures(savedFeatures)
                .imageGallery(savedImageGallery)
                .build();
    }

    private ImageGallery saveImageGallery(ImageGallery gallery, Long supplierId) {
        if (gallery == null || gallery.getImages() == null || gallery.getImages().isEmpty()) {
            return null;
        }

        // Create new entity (existing gallery was deleted earlier)
        ImageGalleryEntity entity = new ImageGalleryEntity();
        entity.setSupplierID(supplierId);
        entity.setImages(new ArrayList<>(gallery.getImages())); // Defensive copy

        ImageGalleryEntity saved = imageGalleryRepository.save(entity);
        return new ImageGallery(saved.getId(), saved.getSupplierID(), saved.getImages());
    }

    private SupplierEntity handleSupplier(Supplier supplierDto) {
        // New supplier (no ID)
        if (supplierDto.getId() == null) {
            return supplierRepository.save(mapper.map(supplierDto, SupplierEntity.class));
        }

        // Existing supplier
        return supplierRepository.findById(supplierDto.getId())
                .map(existing -> {
                    // Update fields except ID
                    mapper.map(supplierDto, existing);
                    return existing;
                })
                .orElseGet(() -> {
                    // ID provided but not found - create new
                    SupplierEntity newEntity = mapper.map(supplierDto, SupplierEntity.class);
                    newEntity.setId(null); // Reset ID for new creation
                    return supplierRepository.save(newEntity);
                });
    }

    private List<ProfilePackage> savePackages(List<ProfilePackage> packages, SupplierEntity supplier) {
        return packages.stream()
                .map(pkgDto -> {
                    ProfilePackageEntity entity = mapper.map(pkgDto, ProfilePackageEntity.class);
                    entity.setSupplier(supplier);

                    // Handle package features
                    if (pkgDto.getFeatures() != null) {
                        List<PackageFeatureEntity> featureEntities = pkgDto.getFeatures().stream()
                                .map(featureDto -> {
                                    PackageFeatureEntity featureEntity = mapper.map(featureDto, PackageFeatureEntity.class);
                                    featureEntity.setProfilePackage(entity);
                                    return featureEntity;
                                })
                                .toList();
                        entity.setFeatures(featureEntities);
                    }

                    return profilePackageRepository.save(entity);
                })
                .map(entity -> mapper.map(entity, ProfilePackage.class))
                .toList();
    }

    private List<PackageFeature> saveExtraFeatures(List<PackageFeature> features, SupplierEntity supplier) {
        // Find or create extra feature entity
        Optional<SupplierExtraFeatureEntity> existing = supplierExtraFeatureRepository.findBySupplierId(supplier.getId());
        SupplierExtraFeatureEntity entity = existing.orElseGet(() ->
                SupplierExtraFeatureEntity.builder()
                        .supplier(supplier)
                        .extraFeatures(new ArrayList<>())
                        .build()
        );

        // Clear and update features
        entity.getExtraFeatures().clear();
        features.forEach(featureDto -> {
            PackageFeatureEntity featureEntity = mapper.map(featureDto, PackageFeatureEntity.class);
            // Set back-reference if needed
            entity.getExtraFeatures().add(featureEntity);
        });

        SupplierExtraFeatureEntity saved = supplierExtraFeatureRepository.save(entity);
        return saved.getExtraFeatures().stream()
                .map(fe -> mapper.map(fe, PackageFeature.class))
                .toList();
    }




    @Override
    public List<AllSupplierDetails> getAllSuppliersWithDetailsUnfiltered() {
        return getAllSuppliers().stream().map(supplier -> {
            // Fetch image gallery
            ImageGallery imageGallery = imageGalleryRepository.findBySupplierID(supplier.getId())
                    .map(entity -> mapper.map(entity, ImageGallery.class))
                    .orElse(null);

            return AllSupplierDetails.builder()
                    .supplier(supplier)
                    .packages(
                            profilePackageRepository.findAll()
                                    .stream()
                                    .filter(pkg -> pkg.getSupplier().getId().equals(supplier.getId()))
                                    .map(pkg -> mapper.map(pkg, ProfilePackage.class))
                                    .toList()
                    )
                    .extraFeatures(
                            supplierExtraFeatureRepository.findAll()
                                    .stream()
                                    .filter(feature -> feature.getSupplier().getId().equals(supplier.getId()))
                                    .flatMap(feature -> feature.getExtraFeatures().stream())
                                    .map(fe -> mapper.map(fe, PackageFeature.class))
                                    .toList()
                    )
                    .imageGallery(imageGallery)  // Add image gallery
                    .build();
        }).toList();
    }

    @Override
    public List<AllSupplierDetails> getAllSuppliersWithDetails() {
        return getAllSuppliers().stream().map(supplier -> {
            // Create filtered supplier
            Supplier filteredSupplier = mapper.map(supplier, Supplier.class);
            filteredSupplier.setBusinessContactNumber(null);
            filteredSupplier.setBusinessEmail(null);
            filteredSupplier.setEmail(null);
            filteredSupplier.setPassword(null);

            // Fetch image gallery
            ImageGallery imageGallery = imageGalleryRepository.findBySupplierID(supplier.getId())
                    .map(entity -> {
                        ImageGallery gallery = mapper.map(entity, ImageGallery.class);
                        gallery.setSupplierID(null);  // Optionally obfuscate supplier ID
                        return gallery;
                    })
                    .orElse(null);

            List<ProfilePackage> packages = profilePackageRepository.findAll()
                    .stream()
                    .filter(pkg -> pkg.getSupplier().getId().equals(supplier.getId()))
                    .map(pkg -> mapper.map(pkg, ProfilePackage.class))
                    .toList();

            List<PackageFeature> extraFeatures = supplierExtraFeatureRepository.findAll()
                    .stream()
                    .filter(feature -> feature.getSupplier().getId().equals(supplier.getId()))
                    .flatMap(feature -> feature.getExtraFeatures().stream())
                    .map(fe -> mapper.map(fe, PackageFeature.class))
                    .toList();

            return AllSupplierDetails.builder()
                    .supplier(filteredSupplier)
                    .packages(packages)
                    .extraFeatures(extraFeatures)
                    .imageGallery(imageGallery)  // Add image gallery
                    .build();
        }).toList();
    }

    @Override
    public List<AllSupplierDetails> getAllSuppliersWithDetailsByCategory(String categoryType) {
        return getAllSuppliersWithDetails()
                .stream()
                .filter(allSupplierDetails -> {
                    Supplier supplier = allSupplierDetails.getSupplier();
                    return supplier != null && supplier.getCategory() != null
                            && supplier.getCategory().name().equals(categoryType);
                })
                .toList();
    }

    @Override
    public AllSupplierDetails getSupplierWithDetailsByID(Long supplierID) {
        return getAllSuppliersWithDetailsUnfiltered()
                .stream()
                .filter(allSupplierDetails -> allSupplierDetails.getSupplier().getId().equals(supplierID))
                .toList()
                .get(0);
    }

    @Override
    @Transactional
    public AllSupplierDetails updateSupplierWithDetails(AllSupplierDetails allSupplierDetails) {
        if (supplierRepository.findById(allSupplierDetails.getSupplier().getId()).isEmpty())
            throw new IllegalArgumentException("Supplier with that ID does not exist!");
        return addSupplierWithDetails(allSupplierDetails);
    }

    @Override
    public List<BeautySaloon> getAllBeautySalon() {
        return beautySaloonRepository.findAll()
                .stream()
                .map(entity -> mapper.map(entity, BeautySaloon.class))
                .collect(Collectors.toList());
    }

    @Override
    public Supplier addBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID) {

        SupplierEntity supplier = findSupplier(supplierID);

        if (supplier.getId() == null) {
            supplier = supplierRepository.save(supplier);
        }

        BeautySaloonEntity saloonEntity = mapper.map(beautySaloon, BeautySaloonEntity.class);

        saloonEntity.setSupplier(supplier);

        BeautySaloonEntity savedSaloon = beautySaloonRepository.save(saloonEntity);

        return mapper.map(supplier, Supplier.class);
    }

    @Override
    public Boolean deleteBeautySalonSupplier(Long supplierID) {
        try {
            beautySaloonRepository.deleteBySupplierId(supplierID);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Supplier updateBeautySalonSupplier(BeautySaloon beautySaloon, Long supplierID) {
        //Retrieve the existing BeautySaloon from the DB
        Optional<BeautySaloonEntity> optionalExistingSalon = beautySaloonRepository.findById(supplierID);

        if (optionalExistingSalon.isPresent()) {
            BeautySaloonEntity existingSalon = optionalExistingSalon.get();

            //Update the fields (excluding the supplier, which will be updated next)
            existingSalon.setSpecialty(beautySaloon.getSpecialty());

            //Update the Supplier details
            if (beautySaloon.getSupplier() != null) {
                Supplier updatedSupplier = beautySaloon.getSupplier();

                // Use ModelMapper if needed
                mapper.map(updatedSupplier, existingSalon.getSupplier());
            }

            //Save the updated BeautySaloon
            beautySaloonRepository.save(existingSalon);

            //Return the updated Supplier
            return mapper.map(existingSalon.getSupplier(), Supplier.class);
        } else {
            throw new EntityNotFoundException("BeautySaloon with ID " + supplierID + " not found");
        }
    }

    @Override
    public BeautySaloon getBeautySalon(Long salonID) {
        BeautySaloonEntity salon = beautySaloonRepository.findById(salonID)
                .orElseThrow(() -> new EntityNotFoundException("BeautySaloon with ID " + salonID + " not found"));

        return mapper.map(salon, BeautySaloon.class);
    }

    @Override
    public Catering addCateringSupplier(Catering catering, Long supplierID) {

        catering.setSupplierId(supplierID);

        return mapper.map(cateringRepository.save(mapper.map(catering, CateringEntity.class)),Catering.class);
    }

    @Override
    public Boolean updateCateringSupplier(Catering catering, Long supplierID) {
        // Find the catering record by supplier ID
        CateringEntity cateringEntity = cateringRepository.findBySupplierId(supplierID)
                .orElseThrow(() -> new EntityNotFoundException("Catering for Supplier ID " + supplierID + " not found"));


        cateringRepository.save(mapper.map(cateringEntity, CateringEntity.class));

        return true;
    }

    @Override
    public Catering getCateringById(Long cateringID) {
        CateringEntity catering = cateringRepository.findById(cateringID)
                .orElseThrow(() -> new EntityNotFoundException("Catering with ID " + cateringID + " not found"));

        return mapper.map(catering, Catering.class);
    }

    @Override
    public List<Catering> getAllCatering() {
        List<CateringEntity> cateringList = cateringRepository.findAll();

        // Use ModelMapper to map each Catering entity to CateringDTO
        return cateringList.stream()
                .map(catering -> mapper.map(catering, Catering.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteCateringSupplier(Long supplierID) {
        CateringEntity cateringEntity = cateringRepository.findBySupplierId(supplierID).orElse(null);

        if (cateringEntity != null) {
            cateringRepository.deleteById(cateringEntity.getCateringId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Music> getAllMusic() {
        List<MusicEntity> musicList = musicRepository.findAll();

        // Use ModelMapper to map each Music entity to MusicDTO
        return musicList.stream()
                .map(music -> mapper.map(music, Music.class))
                .collect(Collectors.toList());
    }

    @Override
    public Supplier addMusicSupplier(Music music, Long supplierID) {
        //Set the supplier ID in the music object
        music.setSupplierId(supplierID);

        //Save the music record
        musicRepository.save(mapper.map(music, MusicEntity.class));

        //Fetch the full supplier object from the repository
        SupplierEntity supplier = supplierRepository.findById(supplierID)
                .orElseThrow(() -> new EntityNotFoundException("Supplier with ID " + supplierID + " not found"));

        return mapper.map(supplier, Supplier.class);
    }

    @Override
    public Music getMusicByID(Long musicID) {
        MusicEntity music = musicRepository.findById(musicID)
                .orElseThrow(() -> new EntityNotFoundException("Music with ID " + musicID + " not found"));

        return mapper.map(music, Music.class);
    }

    @Override
    public Boolean updateMusicSupplier(Music music, Long supplierID) {
        //Retrieve the existing Music by supplier ID
        MusicEntity musicEntity = musicRepository.findBySupplierId(supplierID)
                .orElseThrow(() -> new EntityNotFoundException("Music supplier with ID " + supplierID + " not found"));

        musicRepository.save(mapper.map(music, MusicEntity.class));
        return true;
    }

    @Override
    public Boolean deleteMusicSupplier(Long supplierID) {
        MusicEntity musicEntity = musicRepository.findBySupplierId(supplierID).orElse(null);

        if (musicEntity != null) {
            musicRepository.deleteById(musicEntity.getMusicID());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Meal> getAllCateringMeals() {
        List<MealEntity> meals = mealRepository.findAll();

        return meals.stream()
                .map(meal -> mapper.map(meal, Meal.class))
                .collect(Collectors.toList());
    }

    @Override
    public Catering addCateringMeal(Meal meal, Long cateringID) {
        //Find the Catering by ID
        CateringEntity catering = cateringRepository.findById(cateringID)
                .orElseThrow(() -> new EntityNotFoundException("Catering with ID " + cateringID + " not found"));

        //Set the cateringId in the Meal object
        meal.setCateringId(cateringID);

        //Add the new meal to the existing meals list
        if (catering.getMeals() == null) {
            catering.setMeals(new ArrayList<>());
        }
        catering.getMeals().add(mapper.map(meal, MealEntity.class));

        //Save the updated catering (assuming cascade is configured for meals)
        CateringEntity save = cateringRepository.save(mapper.map(catering, CateringEntity.class));
        return mapper.map(save, Catering.class);
    }

    @Override
    public Boolean deleteCateringMeal(Long id) {
        //Check if the Meal exists
        MealEntity meal = mealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Meal with ID " + id + " not found"));

        //Delete the Meal
        mealRepository.delete(meal);

        //Return success status
        return true;
    }

    @Override
    public Catering updateCateringMeal(Meal meal, Long cateringID) {
        return null;
    }

    @Override
    public List<Catering> searchCateringByMealType(MealType type) {
        return null;
    }

    @Override
    public List<Catering> searchCateringByMealName(String name) {
        return null;
    }

    public Meal searchMealByID(Long id) {
        MealEntity meal=  mealRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Meal with ID " + id + " not found"));
        return mapper.map(meal,Meal.class);
    }

    @Override
    public List<Inventory> getAllInventory() {
        List<InventoryEntity> entity = inventoryRepository.findAll();
        List<Inventory> inventoryList = new ArrayList<>();
        entity.forEach(e -> inventoryList.add(mapper.map(e,Inventory.class)));
        return inventoryList;
    }

    @Override
    public Boolean addInventory(Inventory inventory, Long supplierID) {
        inventoryRepository.save(mapper.map(inventory, InventoryEntity.class));
        return true;
    }

    @Override
    public Inventory searchInventoryByID(Long id) {

        InventoryEntity inventory = inventoryRepository.findById(id).orElse(null);

        return inventory != null
                ? mapper.map(inventory, Inventory.class)
                : null;
    }

    @Override
    public Boolean updateInventory(Inventory inventory, Long supplierID) {
        if (inventoryRepository.existsById(inventory.getInventoryId())) {
            inventoryRepository.save(mapper.map(inventory, InventoryEntity.class));
            return true;
        }

        throw new IllegalArgumentException("Inventory does not exist!");

    }

    @Override
    public Boolean deleteInventory(Long id) {
        return null;
    }

    @Override
    public Boolean addProfilePackage(ProfilePackage profilePackage, Long supplierID) {
        if (profilePackageRepository.existsByPackageName(profilePackage.getPackageName())){
            throw new IllegalArgumentException("PackageName is already exits");
        }
        profilePackageRepository.save(mapper.map(profilePackage, ProfilePackageEntity.class));
        return true;
    }

    @Override
    public List<ProfilePackage> getAllProfilePackages() {
        List<ProfilePackageEntity> all = profilePackageRepository.findAll();

        List<ProfilePackage> profilePackages = new ArrayList<>();

        all.forEach(profilePackagesEntity -> {
            profilePackages.add(mapper.map(profilePackages, ProfilePackage.class));
        });
        return profilePackages;
    }

    @Override
    public Boolean updateProfilePackage(ProfilePackage profilePackage, Long supplierID) {

        if (profilePackageRepository.existsById(profilePackage.getPackageId())) {
            profilePackageRepository.save(mapper.map(profilePackage, ProfilePackageEntity.class));
            return true;
        }

        throw new IllegalArgumentException("Profile Package does not exist!");
    }

    @Override
    public Boolean deleteProfilePackage(Long packageId) {
        profilePackageRepository.deleteById(packageId);
        return true;
    }

    @Override
    public ProfilePackage searchProfilePackageSupplierByID(Long packageId) {
        return mapper.map(profilePackageRepository.findById(packageId),ProfilePackage.class);
    }

    @Override
    public ProfilePackage searchProfilePackageSupplierByName(String packageName) {
        return mapper.map(profilePackageRepository.findByPackageName(packageName), ProfilePackage.class);

    }

    @Override
    public List<ProfilePreviousWork> getAllProfilePreviousWork() {
        return profilePreviousWorkRepository.findAll()
                .stream()
                .map(profilePreviousWorkEntity -> mapper.map(profilePreviousWorkEntity, ProfilePreviousWork.class))
                .toList();
    }

    @Override
    public Boolean addProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID) {
        profilePreviousWorkRepository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class));
        return true;
    }

    @Override
    public Boolean deleteProfilePreviousWork(Long id) {
        if (profilePreviousWorkRepository.existsById(id)) {
            profilePreviousWorkRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ProfilePreviousWork> searchProfilePreviousWorkByID(Long supplierId) {
        return profilePreviousWorkRepository.findBySupplierId(supplierId)
                .stream()
                .map(profilePreviousWorkEntity -> mapper.map(profilePreviousWorkEntity, ProfilePreviousWork.class))
                .toList();
    }

    @Override
    public Boolean updateProfilePreviousWork(ProfilePreviousWork profilePreviousWork, Long supplierID) {
        if (profilePreviousWorkRepository.existsById(profilePreviousWork.getPreviousWorkId())) {
            profilePreviousWorkRepository.save(mapper.map(profilePreviousWork, ProfilePreviousWorkEntity.class));
            return true;
        }

        throw new IllegalArgumentException("Profile Previous Work does not exist!");
    }

    @Override
    public Boolean addSupplierRequest(SupplierRequest supplierRequest, Long supplierID) {
        SupplierEntity supplier = findSupplier(supplierID);
        if (supplier!=null){
            requestReporsitory.save(mapper.map(supplierRequest,SupplierRequestEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public List<SupplierRequest> getAllSupplierRequests() {
        List<SupplierRequestEntity> supplierRequestEntities= requestReporsitory.findAll();
        List<SupplierRequest> supplierRequests = new ArrayList<>();
        supplierRequestEntities.forEach(supplierRequestEntity -> {
            supplierRequests.add(mapper.map(supplierRequestEntity, SupplierRequest.class));
        });
        return supplierRequests;
    }

    @Override
    public SupplierRequest getSupplierRequestByID(Long id) {
        return mapper.map(requestReporsitory.findById(id),SupplierRequest.class);
    }

    @Override
    public Supplier updateSupplierRequest(SupplierRequest supplierRequest, Long supplierID) {

        if (supplierRepository.existsById(supplierRequest.getSupplierId())) {
            requestReporsitory.save(mapper.map(supplierRequest, SupplierRequestEntity.class));
            return mapper.map(findSupplier(supplierID), Supplier.class);
        }

        throw new IllegalArgumentException("Updating fail! supplier request does not exist");


    }

    @Override
    public Boolean deleteSupplierRequest(Long id) {

        if (requestReporsitory.existsById(id)) {
            requestReporsitory.deleteById(id);

            return true;
        }
        throw new IllegalArgumentException("Supplier does not exist!");
    }

    @Override
    public boolean existsByEmail(String email) {
        try{
            return supplierRepository.existsByEmail(email);
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Supplier getSupplierByEmail(String email) {
        return modelMapper.map(supplierRepository.findByEmail(email), Supplier.class);
    }


    private SupplierEntity findSupplier(Long supplierID) {
        SupplierEntity supplierEntity = supplierRepository.findById(supplierID).orElse(null);

        if (supplierEntity == null)
            throw new IllegalArgumentException("Supplier does not exist! Please create a supplier first!");

        return supplierEntity;
    }

    private Catering findCatering(Long cateringID) {
        return  mapper.map(cateringRepository.findById(cateringID),Catering.class) ;
    }

    private ProfilePackage findProfilePackage(Long packageID) {
        return mapper.map(profilePackageRepository.findById(packageID), ProfilePackage.class);
    }

    public Supplier updateSupplier(SupplierEntity supplierEntity) {
        return updateSupplier(mapper.map(supplierEntity, Supplier.class));
    }
}
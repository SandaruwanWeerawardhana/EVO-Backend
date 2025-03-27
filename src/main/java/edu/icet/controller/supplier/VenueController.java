package edu.icet.controller.supplier;

import edu.icet.dto.supplier.*;
import edu.icet.service.supplier.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/supplier/venue")

public class VenueController {

    final VenueService service;
    final HallService hallService;
    final PoolService poolService;
    final RoomService roomService;
    final PropertyImageService propertyImageService;
    final OutdoorAreaService outdoorAreaService;
    final PropertyService propertyService;

    @PostMapping("/save-venue")
    public void saveVenue(@RequestBody Venue venue){
        service.save(venue);
    }

    @GetMapping("/get-all-venue")
    public List<Venue> getVenueData(){
        return service.getAll();
    }

    @GetMapping("/search-venue")
    public Venue searchVenue(@PathVariable Long id){
        return service.search(id);
    }

    @PutMapping("/update-venue")
    public Venue updateVenue(@RequestBody Venue venue){
        return service.update(venue);
    }

    @DeleteMapping("/delete-venue-by-id")
    public boolean deleteVenueById(@RequestParam Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete-venue")
    public boolean deleteVenue(@RequestBody Venue venue){
        return service.delete(venue);
    }
    @PostMapping("/hall/save-hall")
    public void saveHall(@RequestBody Hall hall){
        hallService.save(hall);
    }

    @GetMapping("/hall/get-all-halls")
    public List<Hall> getAllHalls(){
        return hallService.getAll();
    }

    @PutMapping("/hall/update-hall")
    public Hall updateHallData(@RequestBody Hall hall){
        return hallService.update(hall);
    }

    @GetMapping("/hall/search-hall-by-id")
    public Hall searchHall(@RequestBody Hall hall){
        return hallService.search(hall);
    }

    @DeleteMapping("/hall/delete-hall-by-id")
    public boolean deleteHallById(@RequestParam Long id){
        return hallService.delete(id);
    }

    @DeleteMapping("/hall/delete-hall")
    public boolean deleteHall(@RequestBody Hall hall){
        return hallService.delete(hall);
    }
    @PostMapping("/pool/add-pool")
    public Pool savePool(@RequestBody Pool pool){
        return poolService.save(pool);
    }

    @DeleteMapping("/pool/delete-pool/{id}")
    public boolean deletePoolById(@PathVariable Long id){
        return poolService.delete(id);
    }

    @PutMapping("/pool/update-pool")
    public boolean updatePool(@RequestBody Pool pool){
        return poolService.update(pool);
    }

    @GetMapping("/pool/getAll-pools")
    public List <Pool> getAllPool() {
        return poolService.getAll();
    }
    @PostMapping("/room/add-room")
    public void addRoom(@RequestBody Room room){
        roomService.save(room);
    }

    @GetMapping("/room/getAll-rooms")
    public List<Room> getAllRoomData(){
        return roomService.getAll();
    }

    @PutMapping("/room/update-room")
    public Room updateRoom(@RequestBody Room room){
        return roomService.update(room);
    }

    @GetMapping("/room/search-room/{id}")
    public Room searchRoomById(@PathVariable Long id){
        return roomService.search(id);
    }

    @DeleteMapping("/room/delete-room-by-id/{id}")
    public boolean deleteRoomById(@PathVariable Long id) {
        return roomService.delete(id);
    }


    @PostMapping("/property/image/add-property-image")
    public PropertyImage addPropertyImage(@RequestBody PropertyImage propertyImage) {
        return propertyImageService.save(propertyImage);

    }
    @GetMapping("/property/image/getAll-property-images")
    public List<PropertyImage> getAllPropertyImages() {
        return propertyImageService.getAll();
    }

    @DeleteMapping("/property/image/delete-property-image/{id}")
    public boolean deletePropertyImage(@PathVariable Long id) {
        return propertyImageService.delete(id);

    }

    @PutMapping("/property/image/update-property-image")
    public boolean updatePropertyImage(@RequestBody PropertyImage propertyImage){
        return propertyImageService.update(propertyImage);
    }
    @PostMapping("/outdoor-event/add-outdoor-event")
    public OutdoorArea saveOutdoorEvent(@RequestBody OutdoorArea outdoorArea){
        return outdoorAreaService.save(outdoorArea);
    }

    @DeleteMapping("/outdoor-event/delete-outdoor-event-by-id/{id}")
    public boolean deleteOutdoorEventById(@PathVariable Long id){
        return outdoorAreaService.delete(id);
    }

    @PutMapping("/outdoor-event/update-outdoor-event")
    public boolean updateOutdoorEvent(@RequestBody OutdoorArea outdoorArea){
        return outdoorAreaService.update(outdoorArea);
    }

    @GetMapping("/outdoor-event/getAll-outdoor-events")
    public List<OutdoorArea> getAllOutdoorEvents() {
        return outdoorAreaService.getAll();
    }
    @PostMapping("/property/save-property")
    public void saveProperty(@RequestBody Property property){
        propertyService.save(property);
    }

    @GetMapping("/property/get-all-properties")
    public List<Property> getAllProperties(){
        return propertyService.getAll();
    }

    @GetMapping("/property/search-property")
    public Property searchProperty(@RequestBody Property property){
        return propertyService.search(property);
    }

    @PutMapping("/property/update-property")
    public Property updateProperty(@RequestBody Property property){
        return propertyService.update(property);
    }

    @DeleteMapping("/property/delete-by-id")
    public boolean deletePropertyById(@RequestParam Long id){
        return propertyService.delete(id);
    }
}

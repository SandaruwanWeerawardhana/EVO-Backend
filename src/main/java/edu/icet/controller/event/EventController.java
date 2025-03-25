package edu.icet.controller.event;

import edu.icet.dto.event.BirthdayParty;
import edu.icet.dto.event.Event;
import edu.icet.dto.event.Wedding;
import edu.icet.dto.supplier.Location;
import edu.icet.service.event.BirthdayPartyEventService;
import edu.icet.service.event.EventService;
import edu.icet.service.event.WeddingEventService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {
    private final EventService eventService;
    private final BirthdayPartyEventService service;
    private final WeddingEventService weddingEventService;
    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.addEvent(event));
    }

    @GetMapping("/get-all")
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEvent(@PathVariable("id") Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping("/search/{id}")
    public void searchEvent(@PathVariable("id") Long id) {
        eventService.searchEvent(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        return  ResponseEntity.ok(eventService.updateEvent(event,event.getEventId()));
    }

    @GetMapping("/get-by-location")
    public List<Event> getEventByLocation(@RequestBody Location location) {
        return eventService.getEventsByLocation(location);
    }

    @GetMapping("/get-event-type/{eventType}")
    public List<Event> getEventsByEventType(@PathVariable("eventType") EventType eventType) {
        return eventService.getEventsByEventType(eventType);
    }

    @PostMapping("/add-birthday")
    public boolean addBirthday(@RequestBody BirthdayParty birthdayParty) {

        return service.add(birthdayParty);
    }

    @GetMapping("/get-all-birthday")
    public List<BirthdayParty> getAllBirthday() {
        return service.getAll();
    }

    @PutMapping("/update-birthday")
    public boolean updateBirthday(@RequestBody BirthdayParty birthdayParty) {

        return service.update(birthdayParty);
    }

    @GetMapping("/get-all-birthday-by-date")
    public List<BirthdayParty> getAllBirthday(Date date) {
        return service.getAll(date);
    }

    @GetMapping("/get-all-birthday-by-username")
    public List<BirthdayParty> getAllBirthday(String username) {
        return service.getAll(username);
    }

    @DeleteMapping("/delete-birthday")
    public boolean deleteBirthday(@RequestBody BirthdayParty birthdayParty) {
        return service.delete(birthdayParty);
    }

    @DeleteMapping("/delete-birthdayById/{id}")
    public boolean deleteBirthdayById(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @GetMapping("/get-birthdayById-id/{id}")
    public BirthdayParty getBirthdayById(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/get-birthdayByOwnerName/{ownerName}")
    public BirthdayParty getBirthdayOwnerName(@PathVariable("ownerName") String ownerName) {
        return service.get(ownerName);
    }

    @GetMapping("/get-weddingById/{id}")
    public Wedding getWeddingById(@PathVariable("id") Long id){
        return weddingEventService.get(id);
    }

    @GetMapping("/get-weddingByDate/{date}")
    public List<Wedding> getWeddingByDate(@PathVariable("date") LocalDate date){
        return weddingEventService.getByDate(date);
    }

    @GetMapping("/get-all-wedding")
    public List<Wedding> getAllWedding(){
        return weddingEventService.getAll();
    }

    @PostMapping("/save-wedding")
    public boolean saveWedding(@RequestBody Wedding wedding){
        return weddingEventService.add(wedding);
    }

    @DeleteMapping("/delete-weddingById/{id}")
    public boolean deleteWedding(@PathVariable("id") Long id){
        return weddingEventService.delete(id);
    }

    @PutMapping("/update-wedding")
    public boolean updateWedding(@RequestBody Wedding wedding){
        return weddingEventService.update(wedding);
    }

}




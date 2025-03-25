package edu.icet.controller.event;

import edu.icet.dto.event.Anniversary;
import edu.icet.dto.event.Event;
import edu.icet.dto.supplier.Venue;
import edu.icet.service.event.EventService;
import edu.icet.service.event.GetTogetherEventService;
import edu.icet.service.system.EventSummaryService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {

    private final EventService eventService;
    //anniversary Event service
    private final AnniversaryEventService anniversaryEventService;

    //event summary
    private final EventSummaryService eventSummaryService;

     //get together
     private final GetTogetherEventService service;

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

    @GetMapping("/get-by-venue")
    public List<Event> getEventByVenue(@RequestBody Venue venue) {
        return eventService.getEventsByVenue(venue);
    }

    @GetMapping("/get-event-type/{eventType}")
    public List<Event> getEventsByEventType(@PathVariable("eventType") EventType eventType) {
        return eventService.getEventsByEventType(eventType);
    }
  
    @PostMapping("/save-anniversary")
    public boolean addAnniversary(@RequestBody Anniversary anniversary) {
        return anniversaryEventService.add(anniversary);
    }

    @GetMapping("/get-all-anniversary")
    public List<Anniversary> getAllAnniversaries() {
        return anniversaryEventService.getAll();
    }

    @GetMapping("/get-anniversary/{eventId}")
    public Anniversary getAnniversary(@PathVariable("eventId") Long eventId) {
        return anniversaryEventService.get(eventId);
    }

    @PutMapping("/update-anniversary")
    public boolean updateAnniversary(@RequestBody Anniversary anniversary) {
        return anniversaryEventService.update(anniversary);
    }

    @DeleteMapping("/delete-anniversary/{eventId}")
    public boolean deleteAnniversary(@PathVariable("eventId") Long eventId) {
        return anniversaryEventService.delete(eventId);
    }

    //event Summary Controller

    @PostMapping("/add-summary")
    public boolean add(@RequestBody EventSummary eventSummary){
        return eventSummaryService.add(eventSummary);
    }

    @GetMapping("/get-all-summary")
    public List<EventSummary> getAllSummary(){
        return eventSummaryService.getAll();
    }

    @DeleteMapping("/delete-summary/{id}")
    public boolean deleteSummary(@PathVariable("id") Integer id){
        return eventSummaryService.delete(id);
    }

    @PutMapping("/update-summary")
    public boolean updateSummary(@RequestBody EventSummary eventSummary){
        return eventSummaryService.update(eventSummary);
    }

    @GetMapping("/get-summary/{id}")
    public EventSummary getById(@PathVariable("id") Integer id){
        return eventSummaryService.getById(id);
    }

    //getTogether

    @PostMapping("/add-get-together")
    public boolean addGetTogether(@RequestBody GetTogether getTogether){

        return service.add(getTogether);
    }

    @GetMapping("/get-all-get-together")
    public List<GetTogether> getAllGetTogethers(){
        return service.getAll();
    }

    @GetMapping("/search-getTogether/{id}")
    public GetTogether getSearchGetTogether(@PathVariable("id") Integer id){
        return service.get(id);
    }

    @DeleteMapping("/delete-get-together/{id}")
    public boolean deleteGetTogether(@PathVariable("id") Integer id){

        return service.delete(id);
    }

    @PutMapping("/update-getTogether")
    public boolean updateGetTogether(@RequestBody GetTogether  getTogether){
        return service.update(getTogether);
    }

}

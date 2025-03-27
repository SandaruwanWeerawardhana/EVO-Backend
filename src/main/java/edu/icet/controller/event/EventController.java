package edu.icet.controller.event;

import edu.icet.dto.event.*;
import edu.icet.dto.supplier.Venue;
import edu.icet.service.customer.AgendaService;
import edu.icet.service.customer.AnniversaryEventService;
import edu.icet.service.event.BirthdayPartyEventService;
import edu.icet.service.event.EventService;
import edu.icet.service.event.GetTogetherEventService;
import edu.icet.service.system.EventSummaryService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     private final GetTogetherEventService getTogetherEventService;

    private final AgendaService agendaService;

    private final BirthdayPartyEventService birthdayPartyEventService;

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
    public boolean deleteSummary(@PathVariable("id") Long id){
        return eventSummaryService.delete(id);
    }

    @PutMapping("/update-summary")
    public boolean updateSummary(@RequestBody EventSummary eventSummary){
        return eventSummaryService.update(eventSummary);
    }

    @GetMapping("/get-summary/{id}")
    public EventSummary getById(@PathVariable("id") Long id){
        return eventSummaryService.getById(id);
    }

    //getTogether

    @PostMapping("/add-get-together")
    public boolean addGetTogether(@RequestBody GetTogether getTogether){

        return getTogetherEventService.add(getTogether);
    }

    @GetMapping("/get-all-get-together")
    public List<GetTogether> getAllGetTogethers(){
        return getTogetherEventService.getAll();
    }

    @GetMapping("/search-getTogether/{id}")
    public GetTogether getSearchGetTogether(@PathVariable("id") Integer id){
        return getTogetherEventService.get(id);
    }

    @DeleteMapping("/delete-get-together/{id}")
    public boolean deleteGetTogether(@PathVariable("id") Integer id){
        return getTogetherEventService.delete(id);
    }

    @PutMapping("/update-getTogether")
    public boolean updateGetTogether(@RequestBody GetTogether  getTogether){
        return getTogetherEventService.update(getTogether);
    }

    @PostMapping("/agenda/add")
    public boolean createAgenda(@RequestBody Agenda agenda) {
        return agendaService.create(agenda);
    }

    @GetMapping("/agenda/get-all")
    public List<Agenda> getAllAgenda() {
        return agendaService.getAll();
    }

    @PutMapping("/agenda/update")
    public boolean updateAgenda(@RequestBody Agenda agenda) {
        return agendaService.update(agenda);
    }

    @DeleteMapping("/agenda/delete/{id}")
    public boolean deleteAgenda(@PathVariable Integer id) {
        return agendaService.delete(id);
    }

    @GetMapping("/agenda/get/{id}")
    public Agenda getAgendaById(@PathVariable Integer id) {
        return agendaService.getById(id);
    }

    @PostMapping("/agenda/{agendaId}/add-task")
    public boolean addAgendaTaskToAgenda(@PathVariable Integer agendaId, @RequestBody AgendaTask newTask) {
        return agendaService.addTaskToAgenda(agendaId, newTask);
    }

    @PutMapping("/agenda/{agendaId}/task/update/{taskId}")
    public boolean updateAgendaTask(@PathVariable Integer agendaId, @PathVariable Integer taskId, @RequestBody AgendaTask updatedTask) {
        return agendaService.updateTask(agendaId, taskId, updatedTask);
    }

    @DeleteMapping("/agenda/{agendaId}/task/delete/{taskId}")
    public boolean deleteAgendaTask(@PathVariable Integer agendaId, @PathVariable Integer taskId) {
        return agendaService.deleteTask(agendaId, taskId);
    }

    @GetMapping("/agenda/{agendaId}/task/{taskId}")
    public AgendaTask getAgendaTaskById(@PathVariable("agendaId") Integer agendaId, @PathVariable("taskId") Integer taskId) {
        return agendaService.getTaskById(agendaId, taskId);
    }

    @PostMapping("/birthday-party/add")
    private boolean addBirthdayParty(@RequestBody BirthdayParty birthdayParty) {
        return birthdayPartyEventService.add(birthdayParty);
    }

    @GetMapping("/birthday-party/get-all")
    public List<BirthdayParty> getAllBirthdayParties() {
        return birthdayPartyEventService.getAll();
    }

    @PutMapping("/birthday-party/update")
    public boolean updateBirthdayParty(@RequestBody BirthdayParty birthdayParty) {
        return birthdayPartyEventService.update(birthdayParty);
    }

    @GetMapping("/birthday-party/get-all-by-date")
    public List<BirthdayParty> getAllBirthdayPartiesByDate(Date date) {
        return birthdayPartyEventService.getAll(date);
    }

    @GetMapping("/birthday-party/get-all-by-username")
    public List<BirthdayParty> getAllBirthdayPartiesByUsername(String username) {
        return birthdayPartyEventService.getAll(username);
    }

    @DeleteMapping("/birthday-party/delete")
    public boolean deleteBirthdayParty(@RequestBody BirthdayParty birthdayParty) {
        return birthdayPartyEventService.delete(birthdayParty);
    }

    @DeleteMapping("/birthday-party/delete/{id}")
    public boolean deleteBirthdayPartyById(@PathVariable("id") Long id) {
        return birthdayPartyEventService.delete(id);
    }

    @GetMapping("/birthday-party/get-id/{id}")
    public BirthdayParty getBirthdayParty(@PathVariable("id") Long id) {
        return birthdayPartyEventService.get(id);
    }

    @GetMapping("/birthday-party/get-name/{ownerName}")
    public BirthdayParty getBirthdayPartyByOwner(@PathVariable("ownerName") String ownerName) {
        return birthdayPartyEventService.get(ownerName);
    }

}

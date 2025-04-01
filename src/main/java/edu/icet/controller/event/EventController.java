package edu.icet.controller.event;

import edu.icet.dto.event.*;
import edu.icet.dto.supplier.Venue;
import edu.icet.service.customer.AgendaService;
import edu.icet.service.customer.AnniversaryEventService;
import edu.icet.service.event.BirthdayPartyEventService;
import edu.icet.service.event.EventService;
import edu.icet.service.event.GetTogetherEventService;
import edu.icet.service.event.WeddingEventService;
import edu.icet.service.system.EventSummaryService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;

import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/event")
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

    private final WeddingEventService weddingEventService;

    @PostMapping("/")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.addEvent(event));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(eventService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEvent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventService.deleteEvent(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventService.searchEvent(id));
    }

    @PutMapping("/")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        return  ResponseEntity.ok(eventService.updateEvent(event,event.getId()));
    }

    @GetMapping("/by-venue")
    public ResponseEntity<List<Event>> getEventByVenue(@RequestBody Venue venue) {
        return ResponseEntity.ok(eventService.getEventsByVenue(venue));
    }

    @GetMapping("/by-event-type/{eventType}")
    public ResponseEntity<List<Event>> getEventsByEventType(@PathVariable("eventType") EventType eventType) {
        return ResponseEntity.ok(eventService.getEventsByEventType(eventType));
    }
  
    @PostMapping("/anniversary/")
    public ResponseEntity<Boolean> addAnniversary(@RequestBody Anniversary anniversary) {
        return ResponseEntity.ok(anniversaryEventService.add(anniversary));
    }

    @GetMapping("/anniversary/all")
    public ResponseEntity<List<Anniversary>> getAllAnniversaries() {
        return ResponseEntity.ok(anniversaryEventService.getAll());
    }

    @GetMapping("/anniversary/{eventId}")
    public ResponseEntity<Anniversary> getAnniversary(@PathVariable("eventId") Long eventId) {
        return ResponseEntity.ok(anniversaryEventService.get(eventId));
    }

    @PutMapping("/anniversary")
    public ResponseEntity<Boolean> updateAnniversary(@RequestBody Anniversary anniversary) {
        return ResponseEntity.ok(anniversaryEventService.update(anniversary));
    }

    @DeleteMapping("/anniversary/{eventId}")
    public ResponseEntity<Boolean> deleteAnniversary(@PathVariable("eventId") Long eventId) {
        return ResponseEntity.ok(anniversaryEventService.delete(eventId));
    }

    @PostMapping("/summary")
    public ResponseEntity<Boolean> add(@RequestBody EventSummary eventSummary){
        return ResponseEntity.ok(eventSummaryService.add(eventSummary));

    }

    @GetMapping("/summary/all")
    public ResponseEntity<List<EventSummary>> getAllSummary(){
        return ResponseEntity.ok(eventSummaryService.getAll());
    }

    @DeleteMapping("/summary/{id}")
    public ResponseEntity<Boolean> deleteSummary(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventSummaryService.delete(id));
    }

    @PutMapping("/summary")
    public ResponseEntity<Boolean> updateSummary(@RequestBody EventSummary eventSummary){
        return ResponseEntity.ok(eventSummaryService.update(eventSummary));
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<EventSummary> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(eventSummaryService.getById(id));
    }


    @PostMapping("/get-together")
    public ResponseEntity<Boolean> addGetTogether(@RequestBody GetTogether getTogether){
        return ResponseEntity.ok(getTogetherEventService.add(getTogether));
    }

    @GetMapping("/get-together/all")
    public ResponseEntity<List<GetTogether>> getAllGetTogethers(){
        return ResponseEntity.ok(getTogetherEventService.getAll());
    }

    @GetMapping("/getTogether/{id}")
    public ResponseEntity<GetTogether> getSearchGetTogether(@PathVariable("id") Integer id){
        return ResponseEntity.ok(getTogetherEventService.get(id));
    }

    @DeleteMapping("/get-together/{id}")
    public ResponseEntity<Boolean> deleteGetTogether(@PathVariable("id") Integer id){
        return ResponseEntity.ok(getTogetherEventService.delete(id));
    }

    @PutMapping("/getTogether")
    public ResponseEntity<Boolean> updateGetTogether(@RequestBody GetTogether  getTogether){
        return ResponseEntity.ok(getTogetherEventService.update(getTogether));
    }

    @PostMapping("/agenda")
    public ResponseEntity<Boolean> createAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(agendaService.create(agenda));
    }

    @GetMapping("/agenda/all")
    public ResponseEntity<List<Agenda>> getAllAgenda() {
        return ResponseEntity.ok(agendaService.getAll());
    }

    @PutMapping("/agenda")
    public ResponseEntity<Boolean> updateAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(agendaService.update(agenda));
    }

    @DeleteMapping("/agenda/{id}")
    public ResponseEntity<Boolean> deleteAgenda(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.delete(id));
    }

    @GetMapping("/agenda/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        return ResponseEntity.ok(agendaService.getById(id));
    }

    @PostMapping("/agenda-task/{agendaId}")
    public ResponseEntity<Boolean> addAgendaTaskToAgenda(@PathVariable Long agendaId, @RequestBody AgendaTask newTask) {
        return ResponseEntity.ok(agendaService.addTaskToAgenda(agendaId, newTask));
    }

    @PutMapping("/agenda-task")
    public ResponseEntity<Boolean> updateAgendaTask(@RequestParam("agendaId") Long agendaId, @RequestParam("taskId") Long taskId, @RequestBody AgendaTask updatedTask) {
        return ResponseEntity.ok(agendaService.updateTask(agendaId, taskId, updatedTask));
    }

    @DeleteMapping("/agenda-task")
    public ResponseEntity<Boolean> deleteAgendaTask(@RequestParam("agendaId") Long agendaId, @RequestParam("taskId") Long taskId) {
        return ResponseEntity.ok(agendaService.deleteTask(agendaId, taskId));
    }

    @GetMapping("/agenda-task")
    public ResponseEntity<AgendaTask> getAgendaTaskById(@RequestParam("agendaId") Long agendaId, @RequestParam("taskId") Long taskId) {
        return ResponseEntity.ok(agendaService.getTaskById(agendaId, taskId));
    }

    @PostMapping("/birthday-party")
    public ResponseEntity<Boolean> addBirthdayParty(@RequestBody BirthdayParty birthdayParty) {
        return ResponseEntity.ok(birthdayPartyEventService.add(birthdayParty));

    }

    @GetMapping("/birthday-party/all")
    public ResponseEntity<List<BirthdayParty>> getAllBirthdayParties() {
        return ResponseEntity.ok(birthdayPartyEventService.getAll());
    }

    @PutMapping("/birthday-party")
    public ResponseEntity<Boolean> updateBirthdayParty(@RequestBody BirthdayParty birthdayParty) {
        return ResponseEntity.ok(birthdayPartyEventService.update(birthdayParty));
    }

    @GetMapping("/birthday-party/by-username")
    public ResponseEntity<List<BirthdayParty>> getAllBirthdayPartiesByUsername(String username) {
        return ResponseEntity.ok(birthdayPartyEventService.getAll(username));
    }

    @DeleteMapping("/birthday-party/{id}")
    public ResponseEntity<Boolean> deleteBirthdayPartyById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(birthdayPartyEventService.delete(id));
    }

    @GetMapping("/birthday-party/{id}")
    public ResponseEntity<BirthdayParty> getBirthdayParty(@PathVariable("id") Long id) {
        return ResponseEntity.ok(birthdayPartyEventService.get(id));
    }

    @GetMapping("/birthday-party/by-owner-name/{ownerName}")
    public ResponseEntity<BirthdayParty> getBirthdayPartyByOwner(@PathVariable("ownerName") String ownerName) {
        return ResponseEntity.ok(birthdayPartyEventService.get(ownerName));
    }

    @GetMapping("/wedding/{id}")
    public ResponseEntity<Wedding> getWedding(@PathVariable("id") Long id){
        return ResponseEntity.ok(weddingEventService.get(id));
    }

    @GetMapping("/wedding/by-date/{date}")
    public ResponseEntity<List<Wedding>> getWeddingByDate(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(weddingEventService.getByDate(date));
    }


    @GetMapping("/wedding/all")
    public ResponseEntity<List<Wedding>> getAllWedding(){
        return ResponseEntity.ok(weddingEventService.getAll());
    }

    @PostMapping("/wedding")
    public ResponseEntity<Boolean> addWedding(@RequestBody Wedding wedding){
        return ResponseEntity.ok(weddingEventService.add(wedding));
    }

    @DeleteMapping("/wedding/{id}")
    public ResponseEntity<Boolean> deleteWedding(@PathVariable("id") Long id){
        return ResponseEntity.ok(weddingEventService.delete(id));
    }

    @PutMapping("/wedding")
    public ResponseEntity<Boolean> updateWedding(@RequestBody Wedding wedding){
        return ResponseEntity.ok(weddingEventService.update(wedding));
    }
}

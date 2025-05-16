package edu.icet.controller.event;

import edu.icet.config.apidoc.event.EventAddApiDoc;
import edu.icet.dto.event.*;
import edu.icet.service.customer.AgendaService;
import edu.icet.service.event.EventService;
import edu.icet.service.event.EventSummaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;
    private final EventSummaryService eventSummaryService;
    private final AgendaService agendaService;

    private Map<String, String> getValidationErrors (BindingResult result) {
        final Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    private <T> ResponseEntity<T> getResponseEntityWithErrorsHeader (String errorMessage) {
        return ResponseEntity.badRequest().header("errors", errorMessage).build();
    }

    private <T> ResponseEntity<T> getBothLocationAndVenueProvidedError () {
        return this.getResponseEntityWithErrorsHeader("Only one of location or venueId is allowed");
    }

    private <T> ResponseEntity<T> getAnyLocationOrVenueNotProvidedError () {
        return this.getResponseEntityWithErrorsHeader("one of location or venueId is required");
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventFull> getEvent (@PathVariable("id") Long id) {
        final EventFull receivedEvent = this.eventService.get(id);

        return receivedEvent == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(receivedEvent);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventFull>> getAllEvents () {
        return ResponseEntity.ok(this.eventService.getAll());
    }

    @GetMapping("/by-date/{date}")
    public ResponseEntity<List<EventFull>> getAllEventsByDate (@PathVariable("date") LocalDate date) {
        return ResponseEntity.ok(this.eventService.getAllByDate(date));
    }

    @GetMapping("/by-location/{locationId}")
    public ResponseEntity<List<EventFull>> getAllEventsByLocation (@PathVariable("locationId") Long locationId) {
        return ResponseEntity.ok(this.eventService.getAllByLocation(locationId));
    }

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<EventFull>> getAllEventsByUser (@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(this.eventService.getAllByUser(userId));
    }

    @EventAddApiDoc
    @PostMapping("/")
    public ResponseEntity<EventFull> addEvent (@Valid @RequestBody Event event, BindingResult result) {
        if (result.hasErrors()) return this.getResponseEntityWithErrorsHeader(this.getValidationErrors(result).toString());

        if (event.getVenueId() != null && event.getLocation() != null) return this.getBothLocationAndVenueProvidedError();
        if (event.getVenueId() == null && event.getLocation() == null) return this.getAnyLocationOrVenueNotProvidedError();

        final EventFull addedEvent = this.eventService.add(event);

        return addedEvent == null ?
                ResponseEntity.status(304).build() :
                ResponseEntity.ok(addedEvent);
    }

    @PutMapping("/")
    public ResponseEntity<EventFull> updateEvent (@Valid @RequestBody Event event, BindingResult result) {
        if (result.hasErrors()) return this.getResponseEntityWithErrorsHeader(this.getValidationErrors(result).toString());

        if (event.getVenueId() != null && event.getLocation() != null) return this.getBothLocationAndVenueProvidedError();
        if (event.getVenueId() == null && event.getLocation() == null) return this.getAnyLocationOrVenueNotProvidedError();

        final EventFull updatedEvent = this.eventService.update(event);

        return updatedEvent == null ?
                ResponseEntity.status(304).build() :
                ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEvent (@PathVariable("id") Long id) {
        final boolean isDeleted = this.eventService.delete(id);

        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.status(304).build();
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<EventSummaryFull> getEventSummary (@PathVariable("id") Long id) {
        final EventSummaryFull receivedEvent = this.eventSummaryService.get(id);

        return receivedEvent == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(receivedEvent);
    }

    @GetMapping("/summary/all")
    public ResponseEntity<List<EventSummaryFull>> getAllEventSummaries () {
        return ResponseEntity.ok(this.eventSummaryService.getAll());
    }

    @GetMapping("/summary/by-date/{date}")
    public ResponseEntity<List<EventSummaryFull>> getAllEventSummariesByDate (@PathVariable("date") LocalDate date) {
        return ResponseEntity.ok(this.eventSummaryService.getAllByDate(date));
    }

    @GetMapping("/summary/by-location/{locationId}")
    public ResponseEntity<List<EventSummaryFull>> getAllEventSummariesByLocation (@PathVariable("locationId") Long locationId) {
        return ResponseEntity.ok(this.eventSummaryService.getAllByLocation(locationId));
    }

    @GetMapping("/summary/by-user/{userId}")
    public ResponseEntity<List<EventSummaryFull>> getAllEventSummariesByUser (@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(this.eventSummaryService.getAllByUser(userId));
    }

    @PostMapping("/summary")
    public ResponseEntity<EventSummaryFull> addEventSummary (@Valid @RequestBody EventSummary eventSummary, BindingResult result) {
        if (result.hasErrors()) return this.getResponseEntityWithErrorsHeader(this.getValidationErrors(result).toString());

        if (eventSummary.getVenueId() != null && eventSummary.getLocation() != null) return this.getBothLocationAndVenueProvidedError();
        if (eventSummary.getVenueId() == null && eventSummary.getLocation() == null) return this.getAnyLocationOrVenueNotProvidedError();

        final EventSummaryFull addedEventSummary = this.eventSummaryService.add(eventSummary);

        return addedEventSummary == null ?
                ResponseEntity.status(304).build() :
                ResponseEntity.ok(addedEventSummary);
    }

    @PutMapping("/summary")
    public ResponseEntity<EventSummaryFull> updateEventSummary (@Valid @RequestBody EventSummary eventSummary, BindingResult result) {
        if (result.hasErrors()) return this.getResponseEntityWithErrorsHeader(this.getValidationErrors(result).toString());

        if (eventSummary.getVenueId() != null && eventSummary.getLocation() != null) return this.getBothLocationAndVenueProvidedError();
        if (eventSummary.getVenueId() == null && eventSummary.getLocation() == null) return this.getAnyLocationOrVenueNotProvidedError();

        final EventSummaryFull updatedEventSummary = this.eventSummaryService.update(eventSummary);

        return updatedEventSummary == null ?
                ResponseEntity.status(304).build() :
                ResponseEntity.ok(updatedEventSummary);
    }

    @DeleteMapping("/summary/{id}")
    public ResponseEntity<Object> deleteEventSummary (@PathVariable("id") Long id) {
        final boolean isDeleted = this.eventSummaryService.delete(id);

        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.status(304).build();
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

    @PostMapping("/summary/confirm/{id}")
    public ResponseEntity<Boolean> confirmEventSummary (@PathVariable("id") Long id) {
        return this.eventSummaryService.confirm(id) ?
                ResponseEntity.ok(true) :
                ResponseEntity.status(304).build();
    }
}
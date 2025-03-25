package edu.icet.controller.event;

import edu.icet.dto.event.Event;
import edu.icet.dto.supplier.Location;
import edu.icet.service.event.EventService;
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
}




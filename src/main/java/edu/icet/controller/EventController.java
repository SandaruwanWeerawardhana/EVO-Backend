package edu.icet.controller;

import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.service.EventService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {
    private final EventService eventService;
    @PostMapping("/add")
    public boolean addEvent(@RequestBody Event event) {
        return service.addEvent(event);
    }

    @GetMapping("/get-all")
    public List<Event> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEvent(@PathVariable("id") Integer id) {
        return service.deleteEvent(id);
    }

    @PutMapping("/update")
    public boolean updateEvent(@RequestBody Integer id) {
        return service.updateEvent(id);
    }

    @GetMapping("/search/{id}")
    public void searchEvent(@PathVariable("id") Integer id) {
        service.searchEvent(id);
    }

    @PutMapping("/update")
    public boolean updateEvent(@RequestBody Event event) {
        return service.updateEvent(event, event.getEventId());
    }

    @GetMapping("/get-by-location")
    public List<Event> getEventByLocation(@RequestBody Location location) {
        return service.getEventsByLocation(location);
    }

    @GetMapping("/get-event-type/{eventType}")
    public List<Event> getEventsByEventType(@PathVariable("eventType") EventType eventType) {
        return service.getEventsByEventType(eventType);
    }
}




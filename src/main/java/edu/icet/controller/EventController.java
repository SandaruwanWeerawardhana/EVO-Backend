package edu.icet.controller;

import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.service.event.EventService;
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
        return eventService.addEvent(event);
    }

    @GetMapping("/get-all")
    public List<Event> getAll() {
        return eventService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEvent(@PathVariable("id") Integer id) {
        return eventService.deleteEvent(id);
    }

    @PutMapping("/update-by-id")
    public boolean updateEvent(@RequestBody Integer id) {
        return eventService.updateEvent(id);
    }

    @GetMapping("/search/{id}")
    public void searchEvent(@PathVariable("id") Integer id) {
        eventService.searchEvent(id);
    }

    @PutMapping("/update")
    public boolean updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event, event.getEventId());
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




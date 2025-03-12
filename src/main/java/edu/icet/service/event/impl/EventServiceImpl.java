package edu.icet.service.event.impl;

import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.service.event.EventService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final List<Event> events = new ArrayList<>();

    @Override
    public boolean addEvent(Event event) {
        events.add(event);
        return false;
    }

    @Override
    public boolean updateEvent(Event event, Integer id) {
        for (int a=0; a < events.size(); a++) {
            if (events.get(a).getEventId().equals(id)) {
                events.set(a, event);
                return true;
            }
        }
        return false;
    }

    @Override
    public Event searchEvent(Integer id) {
        for (Event event : events) {
            if (event.getEventId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEvent(Integer id) {
        return events.removeIf(event -> event.getEventId().equals(id));
    }

    @Override
    public List<Event> getAll() {
        return events;
    }

    @Override
    public List<Event> getEventsByLocation(Location location) {
        List<Event> eventLocation = new ArrayList<>();
        for (Event event : events) {
            if (event.getLocation().equals(location)) {
                eventLocation.add(event);
            }
        }
        return eventLocation;
    }

    @Override
    public List<Event> getEventsByEventType(EventType eventType) {
        List<Event> eventTest = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventType().equals(eventType)) {
                eventTest.add(event);
            }
        }
        return eventTest;
    }
}


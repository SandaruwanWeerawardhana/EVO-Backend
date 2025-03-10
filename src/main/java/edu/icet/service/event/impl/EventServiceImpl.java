package edu.icet.service.event.impl;

import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.service.event.EventService;
import edu.icet.util.EventType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    @Override
    public boolean addEvent(Event event) {
        return false;
    }

    @Override
    public boolean updateEvent(Event event, Integer id) {
        return false;
    }

    @Override
    public boolean updateEvent(Integer id) {
        return false;
    }

    @Override
    public Event searchEvent(Integer id) {
        return null;
    }

    @Override
    public boolean deleteEvent(Integer id) {
        return false;
    }

    @Override
    public List<Event> getAll() {
        return List.of();
    }

    @Override
    public List<Event> getEventsByLocation(Location location) {
        return List.of();
    }

    @Override
    public List<Event> getEventsByEventType(EventType eventType) {
        return List.of();
    }
}

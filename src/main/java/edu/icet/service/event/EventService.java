package edu.icet.service.event;
import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.util.EventType;


import java.util.List;

public interface EventService {
    Event addEvent(Event event);
    Event updateEvent(Event event, Integer id);
    Event searchEvent(Integer id);
    boolean deleteEvent(Integer id);
    List<Event> getAll();
    List<Event> getEventsByLocation(Location location);
    List<Event> getEventsByEventType(EventType eventType);
}

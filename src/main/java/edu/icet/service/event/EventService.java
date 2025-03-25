package edu.icet.service.event;
import edu.icet.dto.event.Event;
import edu.icet.dto.supplier.Venue;
import edu.icet.util.EventType;
import java.util.List;
public interface EventService {
    Event addEvent(Event event);
    Event updateEvent(Event event, Long id);
    Event searchEvent(Long id);
    boolean deleteEvent(Long id);
    List<Event> getAll();
    List<Event> getEventsByVenue(Venue venue);
    List<Event> getEventsByEventType(EventType eventType);
}

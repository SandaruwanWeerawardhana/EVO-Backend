package edu.icet.service.event;

import edu.icet.dto.event.Event;
import edu.icet.dto.event.EventFull;
import edu.icet.dto.event.EventSupplierResponse;
import edu.icet.util.SupplierCategoryType;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    EventFull add (Event event);
    EventFull update (Event event);
    EventFull get (Long id);
    List<EventFull> getAll ();
    List<EventFull> getAllByDate (LocalDate date);
    List<EventFull> getAllByLocation (Long locationId);
    List<EventFull> getAllByUser (Long userId);
    boolean delete (Long id);

    List<EventSupplierResponse> eventSupplierResponses(Long eventId, String searchSteam, SupplierCategoryType categoryType,Boolean availability);
}
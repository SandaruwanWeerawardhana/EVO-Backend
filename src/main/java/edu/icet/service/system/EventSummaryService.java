package edu.icet.service.system;

import edu.icet.dto.event.EventSummary;

import java.util.List;

public interface EventSummaryService {

    boolean add(EventSummary eventSummary);

    boolean update(EventSummary eventSummary);

    boolean delete(Long id);

    List<EventSummary> getAll();

    EventSummary getById(Long id);

    List<EventSummary> getEventSummariesByCustomerId(Long customerId);

}

package edu.icet.service.system;

import edu.icet.dto.event.EventSummary;

import java.util.List;

public interface EventSummaryService {

    boolean add(EventSummary eventSummary);

    boolean update(EventSummary eventSummary);

    boolean delete(Integer id);

    List<EventSummary> getAll();

    EventSummary getById(Integer id);

    List<EventSummary> getEventSummariesByCustomerId(Long customerId);
}

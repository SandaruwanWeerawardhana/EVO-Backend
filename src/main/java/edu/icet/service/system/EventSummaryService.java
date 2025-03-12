package edu.icet.service.system;

import edu.icet.dto.EventSummary;

import java.util.List;

public interface EventSummaryService {

    boolean add(EventSummary eventSummary);

    boolean update(EventSummary eventSummary);

    boolean delete(Integer id);

    List<EventSummary> getall();

    EventSummary getById(Integer id);
}

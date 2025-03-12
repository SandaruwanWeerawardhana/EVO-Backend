package edu.icet.service.event;

import edu.icet.dto.EventReport;
import edu.icet.util.EventType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface EventReportService {
    boolean saveEventReport(EventReport eventReport);
    boolean updateEventReport(Long id,EventReport eventReport);
    EventReport getEventReportById(Long id);
    List<EventReport> getAllEventReports();
    List<EventReport> getEventReportsByEventType(EventType eventType);
    boolean deleteEventReportById(Long id);
}

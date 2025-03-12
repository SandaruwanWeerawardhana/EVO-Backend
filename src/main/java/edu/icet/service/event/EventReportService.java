package edu.icet.service.event;

import edu.icet.dto.EventReport;
import java.util.List;

public interface EventReportService {
    boolean saveEventReport(EventReport eventReport);
    boolean updateEventReport(Long id,EventReport eventReport);
    EventReport getEventReportById(Long id);
    List<EventReport> getAllEventReports();
    boolean deleteEventReportById(Long id);
}

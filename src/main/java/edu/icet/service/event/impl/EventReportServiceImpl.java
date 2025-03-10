package edu.icet.service.event.impl;

import edu.icet.dto.EventReport;
import edu.icet.service.event.EventReportService;
import edu.icet.util.EventType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventReportServiceImpl implements EventReportService {
    @Override
    public boolean saveEventReport(EventReport eventReport) {
        return false;
    }

    @Override
    public boolean updateEventReport(Long id, EventReport eventReport) {
        return false;
    }

    @Override
    public EventReport getEventReportById(Long id) {
        return null;
    }

    @Override
    public List<EventReport> getAllEventReports() {
        return List.of();
    }

    @Override
    public List<EventReport> getEventReportsByLocation(String location) {
        return List.of();
    }

    @Override
    public List<EventReport> getEventReportsByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<EventReport> getEventReportsByEventType(EventType eventType) {
        return List.of();
    }

    @Override
    public boolean deleteEventReportById(Long id) {
        return false;
    }
}

package edu.icet.service.event.impl;

import edu.icet.dto.EventReport;
import edu.icet.service.event.EventReportService;
import edu.icet.util.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class EventReportServiceImpl implements EventReportService {
    List<EventReport> eventReportsList = new ArrayList<>();

    @Override
    public boolean saveEventReport(EventReport eventReport) {
        if (eventReport == null) {
            log.info("event report is null");
            return false;
        }
        return eventReportsList.add(eventReport);
    }

    @Override
    public boolean updateEventReport(Long id, EventReport eventReport) {
        if (eventReport == null) {
            log.info("event report is null");
            return false;
        }
        for (int i = 0; i < eventReportsList.size(); i++) {
            EventReport existingEventReport = eventReportsList.get(i);
            if (existingEventReport.getEventId().equals(id)) {
                eventReportsList.set(i, eventReport);
                return true;
            }
        }
        log.info("event report with ID {} not found", id);
        return false;
    }

    @Override
    public EventReport getEventReportById(Long id) {
        if (id == null || eventReportsList.isEmpty()) {
            log.info("event report list is empty or id is null");
            return null;
        }
        for (EventReport existingEventReport : eventReportsList) {
            if (existingEventReport.getEventId().equals(id)) {
                return existingEventReport;
            }
        }
        log.info("event report with ID {} not found", id);
        return null;
    }

    @Override
    public List<EventReport> getAllEventReports() {
        if (eventReportsList != null) {
            return eventReportsList;
        } else {
            log.info("event reports not found");
            return null;
        }
    }

    @Override
    public List<EventReport> getEventReportsByEventType(EventType eventType) {
        ArrayList<EventReport> eventReports = new ArrayList<>();
        if (eventReportsList.isEmpty() || eventType == null) {
            log.info("event report list is empty or event type is null");
            return Collections.emptyList();
        }
        for (EventReport existingEventReport : eventReportsList) {
            if (existingEventReport.getEventType().equals(eventType)) {
                eventReports.add(existingEventReport);
            }
        }
        return eventReports;
    }

    @Override
    public boolean deleteEventReportById(Long id) {
        if (eventReportsList == null || id == null) {
            log.info("event report list is empty or eventId is null");
            return false;
        }
        for (EventReport existingEventReport : eventReportsList) {
            if (existingEventReport.getEventId().equals(id)) {
                eventReportsList.remove(id.intValue());
                return true;
            }
        }
        log.info("event report with ID {} not found", id);
        return false;

    }
}

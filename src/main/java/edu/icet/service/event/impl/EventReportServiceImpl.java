package edu.icet.service.event.impl;

import edu.icet.dto.EventReport;
import edu.icet.service.event.EventReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EventReportServiceImpl implements EventReportService {
    List<EventReport> eventReportsList = new ArrayList<>();


    @Override
    public boolean saveEventReport(EventReport eventReport) {
        if (eventReport == null) {
            return false;
        } else {
            return eventReportsList.add(eventReport);

        }
    }

    @Override
    public boolean updateEventReport(Long id, EventReport eventReport) {
        for (int i = 0; i < eventReportsList.size(); i++) {
            if (eventReportsList.get(i).getReportId().equals(id)) {
                eventReportsList.set(i, eventReport);
                return true;
            }
        }
        return false;
    }

    @Override
    public EventReport getEventReportById(Long id) {
        for (EventReport report : eventReportsList) {
            if (report.getReportId().equals(id)) {
                return report;
            }
        }
        return null;
    }

    @Override
    public List<EventReport> getAllEventReports() {
        if(eventReportsList!=null){
            return new ArrayList<>(eventReportsList);
        }
        return null;
    }

    @Override
    public boolean deleteEventReportById(Long id) {
        if (id == null) {
            return false;
        } else {
            return eventReportsList.removeIf(eventReport -> Objects.equals(eventReport.getReportId(), id));
        }
    }
}

package edu.icet.service.event.impl;

import edu.icet.dto.event.EventReport;
import edu.icet.entity.event.EventReportEntity;
import edu.icet.repository.event.EventReportRepository;
import edu.icet.service.event.EventReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventReportServiceImpl implements EventReportService {

    final EventReportRepository eventReportRepository;
    final ModelMapper modelMapper;

    @Override
    public boolean saveEventReport(EventReport eventReport) {
        if (eventReport == null) {
            return false;
        }
        EventReportEntity savedEntity = eventReportRepository.save(modelMapper.map(eventReport, EventReportEntity.class));
        return true;
    }

    @Override
    public boolean updateEventReport(Long id, EventReport eventReport) {
        if (eventReport == null || id == null) {
            return false;
        }
        EventReportEntity updatedEntity = eventReportRepository.save(modelMapper.map(eventReport, EventReportEntity.class));
        return updatedEntity.getReportId().equals(id);
    }

    @Override
    public EventReport getEventReportById(Long id) {
        if (id == null) {
            return null;
        }
        return modelMapper.map(eventReportRepository.findById(id), EventReport.class);
    }

    @Override
    public List<EventReport> getAllEventReports() {
        List<EventReport> eventReports = new ArrayList<>();
        eventReportRepository.findAll().forEach(eventReport ->
                eventReports.add(modelMapper.map(eventReport, EventReport.class)));
        return eventReports;
    }

    @Override
    public boolean deleteEventReportById(Long id) {
        if (id == null) {
            return false;
        }
        eventReportRepository.deleteById(id);
        return true;
    }
}

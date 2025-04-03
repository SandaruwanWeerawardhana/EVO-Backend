package edu.icet.service.system.impl;

import edu.icet.dto.event.EventSummary;
import edu.icet.entity.event.EventSummaryEntity;
import edu.icet.repository.event.EventSummaryRepository;
import edu.icet.service.system.EventSummaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventSummaryServiceImpl implements EventSummaryService {

    private final EventSummaryRepository eventSummaryRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean add(EventSummary eventSummary) {
        eventSummaryRepository.save(modelMapper.map(eventSummary, EventSummaryEntity.class));
        return true;
    }

    @Override
    public boolean update(EventSummary eventSummary) {
        this.add(eventSummary);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        eventSummaryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<EventSummary> getAll() {
        List<EventSummary> eventSummaryList = new ArrayList<>();
        List<EventSummaryEntity> all = eventSummaryRepository.findAll();
        all.forEach(eventSummaryEntity -> eventSummaryList.add(modelMapper.map(eventSummaryEntity, EventSummary.class)));
        return eventSummaryList;
    }

    @Override
    public EventSummary getById(Integer id) {
        return modelMapper.map(eventSummaryRepository.findById(id), EventSummary.class);
    }

    @Override
    public List<EventSummary> getEventSummariesByCustomerId(Long customerId) {
        return eventSummaryRepository.findAllByCustomerId(customerId)
                .stream()
                .map(eventSummaryEntity -> modelMapper.map(eventSummaryEntity, EventSummary.class))
                .collect(Collectors.toList());
    }


}

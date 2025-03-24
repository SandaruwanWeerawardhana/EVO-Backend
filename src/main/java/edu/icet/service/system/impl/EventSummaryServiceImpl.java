package edu.icet.service.system.impl;

import edu.icet.dto.EventSummary;
import edu.icet.entity.EventSummaryEntity;
import edu.icet.repository.EventSummaryRepository;
import edu.icet.service.system.EventSummaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


}

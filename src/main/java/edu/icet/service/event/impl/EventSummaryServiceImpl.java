package edu.icet.service.event.impl;

import edu.icet.dto.event.EventSummary;
import edu.icet.dto.event.EventSummaryFull;
import edu.icet.entity.event.EventSummaryEntity;
import edu.icet.entity.event.EventSummaryFullEntity;
import edu.icet.repository.event.EventSummaryRepository;
import edu.icet.service.event.EventSummaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class EventSummaryServiceImpl implements EventSummaryService {
    private final EventSummaryRepository eventSummaryRepository;
    private final ModelMapper mapper;

    @Override
    public EventSummaryFull add (EventSummary eventSummary) {
        final EventSummaryFullEntity addedEventSummary = this.eventSummaryRepository.add(this.mapper.map(eventSummary, EventSummaryEntity.class));
        return addedEventSummary == null ? null : this.mapper.map(addedEventSummary, EventSummaryFull.class);
    }

    @Override
    public EventSummaryFull update (EventSummary eventSummary) {
        final EventSummaryFullEntity updatedEventSummary = this.eventSummaryRepository.update(this.mapper.map(eventSummary, EventSummaryEntity.class));
        return updatedEventSummary == null ? null : this.mapper.map(updatedEventSummary, EventSummaryFull.class);
    }

    @Override
    public EventSummaryFull get (Long id) {
        final EventSummaryFullEntity receivedEventSummary = this.eventSummaryRepository.get(id);
        return receivedEventSummary == null ? null : this.mapper.map(receivedEventSummary, EventSummaryFull.class);
    }

    @Override
    public List<EventSummaryFull> getAll () {
        return this.eventSummaryRepository.getAll().stream().map(eventSummaryFullEntity -> this.mapper.map(eventSummaryFullEntity, EventSummaryFull.class)).toList();
    }

    @Override
    public List<EventSummaryFull> getAllByDate (LocalDate date) {
        return this.eventSummaryRepository.getAllByDate(date).stream().map(eventSummaryFullEntity -> this.mapper.map(eventSummaryFullEntity, EventSummaryFull.class)).toList();
    }

    @Override
    public List<EventSummaryFull> getAllByLocation (Long locationId) {
        return this.eventSummaryRepository.getAllByLocation(locationId).stream().map(eventSummaryFullEntity -> this.mapper.map(eventSummaryFullEntity, EventSummaryFull.class)).toList();
    }

    @Override
    public List<EventSummaryFull> getAllByUser (Long userId) {
        return this.eventSummaryRepository.getAllByUser(userId).stream().map(eventSummaryFullEntity -> this.mapper.map(eventSummaryFullEntity, EventSummaryFull.class)).toList();
    }

    @Override
    public boolean delete (Long id) {
        return this.eventSummaryRepository.delete(id);
    }

    @Override
    public boolean confirm (Long id) {
        return this.eventSummaryRepository.confirm(id);
    }
}
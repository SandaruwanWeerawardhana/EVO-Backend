package edu.icet.service.event.impl;

import edu.icet.dto.event.Event;
import edu.icet.dto.supplier.Venue;
import edu.icet.entity.event.EventEntity;
import edu.icet.repository.event.EventRepository;
import edu.icet.service.event.EventService;
import edu.icet.util.EventType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventDao;
    private final ModelMapper modelMapper;

    @Override
    public Event addEvent(Event event) {
        return modelMapper.map(eventDao.save(modelMapper.map(event, EventEntity.class)), Event.class);
    }

    @Override
    public Event updateEvent(Event event, Long id) {
        event.setEventId(id);
        return modelMapper.map(eventDao.save(modelMapper.map(event, EventEntity.class)), Event.class);
    }

    @Override
    public Event searchEvent(Long id) {
        return modelMapper.map( eventDao.findById(id), Event.class);
    }

    @Override
    public boolean deleteEvent(Long id) {
        eventDao.deleteById(id);
        return eventDao.existsById(id) ;
    }

    @Override
    public List<Event> getAll() {
        List<EventEntity> eventEntities = eventDao.findAll();
        List<Event> events = new ArrayList<>();
        for(EventEntity eventEntity : eventEntities){
            events.add(modelMapper.map(eventEntity,Event.class));
        }
        return events;
    }

    @Override
    public List<Event> getEventsByVenue(Venue venue) {
        List<EventEntity> eventEntities = eventDao.findAllByVenueId(venue.getVenueId());
        List<Event> events = new ArrayList<>();
        for(EventEntity eventEntity : eventEntities){
            events.add(modelMapper.map(eventEntity,Event.class));
        }
        return events;
    }

    @Override
    public List<Event> getEventsByEventType(EventType eventType) {
        List<EventEntity> eventEntities = eventDao.findAllByEventType(eventType);
        List<Event> events = new ArrayList<>();
        for(EventEntity eventEntity : eventEntities){
            events.add(modelMapper.map(eventEntity,Event.class));
        }
        return events;
    }
}


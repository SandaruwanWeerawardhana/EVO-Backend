package edu.icet.service.event.impl;

import edu.icet.dto.Event;
import edu.icet.dto.Location;
import edu.icet.entity.EventEntity;
import edu.icet.repository.EventRepository;
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
    public Event updateEvent(Event event, Integer id) {
        event.setEventId(id);
        return modelMapper.map(eventDao.save(modelMapper.map(event, EventEntity.class)), Event.class);
    }

    @Override
    public Event searchEvent(Integer id) {
        return modelMapper.map( eventDao.findById(id), Event.class);
    }

    @Override
    public boolean deleteEvent(Integer id) {
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
    public List<Event> getEventsByLocation(Location location) {
        List<EventEntity> eventEntities = eventDao.findAllByLocationId(location.getLocationId());
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


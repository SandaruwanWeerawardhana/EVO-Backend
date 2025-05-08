package edu.icet.service.event.impl;

import edu.icet.dto.event.Event;
import edu.icet.dto.supplier.Venue;
import edu.icet.entity.event.EventEntity;
import edu.icet.repository.event.EventRepository;
import edu.icet.service.event.EventService;
import edu.icet.util.EventType;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository eventDao;
    private final ModelMapper modelMapper;
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Event addEvent(Event event) {

        System.out.println(event);
        // Check if the entity is detached and merge it
        if (event.getId() != null && entityManager.contains(event)) {
            // Entity is already managed (attached)
            entityManager.persist(modelMapper.map(event,EventEntity.class));  // This is safe if the entity is managed
        } else {
            // Entity is detached, so we merge it
            entityManager.merge(modelMapper.map(event,EventEntity.class));  // This reattaches the entity
        }
        return null;
    }


    @Override
    public Event updateEvent(Event event, Long id) {
        event.setId(id);
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


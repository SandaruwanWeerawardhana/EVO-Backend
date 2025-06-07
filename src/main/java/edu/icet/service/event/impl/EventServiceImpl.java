package edu.icet.service.event.impl;

import edu.icet.dto.event.Event;
import edu.icet.dto.event.EventFull;
import edu.icet.dto.event.EventSupplierResponse;
import edu.icet.entity.event.EventEntity;
import edu.icet.entity.event.EventFullEntity;
import edu.icet.entity.event.EventSummarySuppliersEntity;
import edu.icet.entity.event.EventSupplierEntity;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.repository.event.EventRepository;
import edu.icet.repository.event.EventSummarySuppliersRepository;
import edu.icet.service.event.EventService;
import edu.icet.util.SupplierCategoryType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private  final EventSummarySuppliersRepository eventSummarySuppliersRepository;
    private final EventRepository eventRepository;
    private final ModelMapper mapper;

    @Override
    public EventFull add (Event event) {
        final EventFullEntity addedEvent = this.eventRepository.add(this.mapper.map(event, EventEntity.class));
        return addedEvent == null ? null : this.mapper.map(addedEvent, EventFull.class);
    }

    @Override
    public EventFull update (Event event) {
        final EventFullEntity updatedEvent = this.eventRepository.update(this.mapper.map(event, EventEntity.class));
        return updatedEvent == null ? null : this.mapper.map(updatedEvent, EventFull.class);
    }

    @Override
    public EventFull get (Long id) {
        final EventFullEntity receivedEvent = this.eventRepository.get(id);
        return receivedEvent == null ? null : this.mapper.map(receivedEvent, EventFull.class);
    }

    @Override
    public List<EventFull> getAll () {
        return this.eventRepository.getAll().stream().map(eventFullEntity -> this.mapper.map(eventFullEntity, EventFull.class)).toList();
    }

    @Override
    public List<EventFull> getAllByDate (LocalDate date) {
        return this.eventRepository.getAllByDate(date).stream().map(eventFullEntity -> this.mapper.map(eventFullEntity, EventFull.class)).toList();
    }

    @Override
    public List<EventFull> getAllByLocation (Long locationId) {
        return this.eventRepository.getAllByLocation(locationId).stream().map(eventFullEntity -> this.mapper.map(eventFullEntity, EventFull.class)).toList();
    }

    @Override
    public List<EventFull> getAllByUser (Long userId) {
        return this.eventRepository.getAllByUser(userId).stream().map(eventFullEntity -> this.mapper.map(eventFullEntity, EventFull.class)).toList();
    }

    @Override
    public boolean delete (Long id) {
        return this.eventRepository.delete(id);
    }

    @Override
    public List<EventSupplierResponse> eventSupplierResponses(Long eventId, String searchSteam, SupplierCategoryType categoryType, Boolean availability) {
        try {
            EventSummarySuppliersEntity event = eventSummarySuppliersRepository.findById(eventId)
                    .orElseThrow(() -> new RuntimeException("Event Not found " + eventId));

            List<EventSupplierEntity> eventSupplierEntities = eventSummarySuppliersRepository.findByEventSummary(event);

            return eventSupplierEntities.stream()
                    .map(EventSupplierEntity::getSupplier)
                    .filter(supplier -> matchesSearchTerm(supplier, searchSteam))
                    .filter(supplier -> matchesCategory(supplier, categoryType))
                    .filter(supplier -> matchesAvailability(supplier, availability))
                    .map(this::convertToResponse)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.err.println("Error occurred while fetching event suppliers: " + e.getMessage());


            return new ArrayList<>();
        }
    }

    private boolean matchesSearchTerm(SupplierEntity supplier, String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return true;
        }
        String lowerSearchTerm = searchTerm.toLowerCase();
        return supplier.getBusinessName().toLowerCase().contains(lowerSearchTerm) ||
                supplier.getBusinessEmail().toLowerCase().contains(lowerSearchTerm);
    }

    private boolean matchesCategory(SupplierEntity supplier, SupplierCategoryType category) {
        return category == null || supplier.getCategory() == category;
    }

    private boolean matchesAvailability(SupplierEntity supplier, Boolean availability) {
        return availability == null || supplier.getAvailability().equals(availability);
    }

    private EventSupplierResponse convertToResponse(SupplierEntity supplier) {
        return  mapper.map(supplier,EventSupplierResponse.class);
    }
}

package edu.icet.repository.event.impl;

import edu.icet.entity.customer.UserEntity;
import edu.icet.entity.event.*;
import edu.icet.entity.supplier.VenueEntity;
import edu.icet.repository.customer.UserRepository;
import edu.icet.repository.event.*;
import edu.icet.repository.supplier.VenueRepository;
import edu.icet.util.BudgetType;
import edu.icet.util.DBConnection;
import edu.icet.util.EventStatusType;
import edu.icet.util.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Primary
@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventRepository {
    private final DBConnection dbConnection;
    private final Logger logger;
    private final UserRepository userRepository;
    private final VenueRepository venueRepository;
    private final AnniversaryRepository anniversaryRepository;
    private final BirthdayPartyRepository birthdayPartyRepository;
    private final GetTogetherRepository getTogetherRepository;
    private final WeddingRepository weddingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Map<String, Object> getEventEntityNestedObjects (EventEntity event) {
        final Long userId = event.getUserId();
        final UserEntity user = userId == null ?
                null :
                this.userRepository.findById(userId).orElse(null);

        if (userId != null && user == null) return Map.of();

        final Long venueId = event.getVenueId();
        final VenueEntity venue = venueId == null ?
                null :
                this.venueRepository.findById(venueId).orElse(null);

        if (venueId != null && venue == null) return Map.of();

        final Map<String, Object> nestedObjects = new HashMap<>();

        nestedObjects.put("user", user);
        nestedObjects.put("venue", venue);

        return nestedObjects;
    }

    private void putNestedObjectsIntoEventFullEntity (Map<String, Object> nestedObjects, EventFullEntity eventFullEntity) {
        eventFullEntity.setUser((UserEntity) nestedObjects.get("user"));
        eventFullEntity.setVenue((VenueEntity) nestedObjects.get("venue"));
    }

    private <T> boolean insertEventSubCategoryHelper (T entity, SuperEventRepository<T> repository, Consumer<T> setter, boolean isUpdate) {
        if (entity == null) return true;

        final T addedEntity = isUpdate ? repository.update(entity) : repository.add(entity);

        if (addedEntity == null) return false;

        setter.accept(addedEntity);
        return true;
    }

    private boolean insertEventSubCategory (EventEntity event, EventFullEntity eventFullEntity) {
        return switch (event.getEventType()) {
            case ANNIVERSARIES -> this.insertEventSubCategoryHelper(event.getAnniversary(), this.anniversaryRepository, eventFullEntity::setAnniversary, false);
            case BIRTHDAY_PARTIES -> this.insertEventSubCategoryHelper(event.getBirthdayParty(), this.birthdayPartyRepository, eventFullEntity::setBirthdayParty, false);
            case GET_TOGETHER -> this.insertEventSubCategoryHelper(event.getGetTogether(), this.getTogetherRepository, eventFullEntity::setGetTogether, false);
            case WEDDING -> this.insertEventSubCategoryHelper(event.getWedding(), this.weddingRepository, eventFullEntity::setWedding, false);
        };
    }

    private boolean updateEventSubCategory (EventEntity event, EventFullEntity eventFullEntity) {
        return switch (event.getEventType()) {
            case ANNIVERSARIES -> this.insertEventSubCategoryHelper(event.getAnniversary(), this.anniversaryRepository, eventFullEntity::setAnniversary, true);
            case BIRTHDAY_PARTIES -> this.insertEventSubCategoryHelper(event.getBirthdayParty(), this.birthdayPartyRepository, eventFullEntity::setBirthdayParty, true);
            case GET_TOGETHER -> this.insertEventSubCategoryHelper(event.getGetTogether(), this.getTogetherRepository, eventFullEntity::setGetTogether, true);
            case WEDDING -> this.insertEventSubCategoryHelper(event.getWedding(), this.weddingRepository, eventFullEntity::setWedding, true);
        };
    }

    @Override
    @Transactional
    public EventFullEntity add (EventEntity event) {
        try {
            final Query eventInsertQuery = this.entityManager.createNativeQuery("""
				INSERT INTO event
				(user_id, venue_id, location, event_date, start_time, end_time, event_type, head_count, total_price, budget_type, event_status)
				VALUES (:user_id, :venue_id, :location, :event_date, :start_time, :end_time, :event_type, :head_count, :total_price, :budget_type, :event_status)
				""", EventEntity.class);

            eventInsertQuery.setParameter("user_id", event.getUserId());
            eventInsertQuery.setParameter("venue_id", event.getVenueId());
            eventInsertQuery.setParameter("location", event.getLocation());
            eventInsertQuery.setParameter("event_date", event.getEventDate());
            eventInsertQuery.setParameter("start_time", event.getStartTime());
            eventInsertQuery.setParameter("end_time", event.getEndTime());
            eventInsertQuery.setParameter("event_type", event.getEventType().name());
            eventInsertQuery.setParameter("head_count", event.getHeadCount());
            eventInsertQuery.setParameter("total_price", event.getTotalPrice());
            eventInsertQuery.setParameter("budget_type", event.getBudgetType().name());
            eventInsertQuery.setParameter("event_status", EventStatusType.ON_HOLD.name());

            eventInsertQuery.executeUpdate();

            final Long insertedId = ((Number) this.entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).longValue();
            final EventEntity addedEventEntity = this.entityManager.find(EventEntity.class, insertedId);

            final Map<String, Object> nestedObjects = this.getEventEntityNestedObjects(event);

            if (nestedObjects.isEmpty()) throw new IllegalStateException("Nested objects missing. Cannot continue.");

            final EventFullEntity eventFullEntity = EventFullEntity.builder()
                    .id(insertedId)
                    .eventDate(addedEventEntity.getEventDate())
                    .startTime(addedEventEntity.getStartTime())
                    .endTime(addedEventEntity.getEndTime())
                    .eventType(addedEventEntity.getEventType())
                    .headCount(addedEventEntity.getHeadCount())
                    .totalPrice(addedEventEntity.getTotalPrice())
                    .budgetType(addedEventEntity.getBudgetType())
                    .eventStatus(addedEventEntity.getEventStatus())
                    .location(addedEventEntity.getLocation())
                    .build();

            if (!this.insertEventSubCategory(event, eventFullEntity)) throw new IllegalStateException("Failed to insert subcategories.");

            this.putNestedObjectsIntoEventFullEntity(nestedObjects, eventFullEntity);
            return eventFullEntity;
        } catch (Exception exception) {
            this.logger.error(exception.getMessage());
            throw exception;
        }
    }

    @Override
    @Transactional
    public EventFullEntity update (EventEntity event) {
        try {
            final Connection connection = this.dbConnection.getConnection();

            connection.setAutoCommit(false);

            if ((Integer) this.dbConnection.execute(
                    "UPDATE event SET user_id = ?, venue_id = ?, location = ?, event_date = ?, start_time = ?, end_time = ?, event_type = ?, head_count = ?, total_price = ?, budget_type = ?, event_status = ? WHERE id = ? AND is_deleted = FALSE",
                    event.getUserId(),
                    event.getVenueId(),
                    event.getLocation(),
                    event.getEventDate(),
                    event.getStartTime(),
                    event.getEndTime(),
                    event.getEventType().name(),
                    event.getHeadCount(),
                    event.getTotalPrice(),
                    event.getBudgetType().name(),
                    event.getEventStatus().name(),
                    event.getId()
            ) == 0) {
                connection.rollback();
                return null;
            }

            final Map<String, Object> nestedObjects = this.getEventEntityNestedObjects(event);

            if (nestedObjects.isEmpty()) {
                connection.rollback();
                return null;
            }

            final EventFullEntity eventFullEntity = EventFullEntity.builder()
                    .id(event.getId())
                    .eventDate(event.getEventDate())
                    .startTime(event.getStartTime())
                    .endTime(event.getEndTime())
                    .eventType(event.getEventType())
                    .headCount(event.getHeadCount())
                    .budgetType(event.getBudgetType())
                    .eventStatus(event.getEventStatus())
                    .location(event.getLocation())
                    .build();

            if (!this.updateEventSubCategory(event, eventFullEntity)) {
                connection.rollback();
                return null;
            }

            this.putNestedObjectsIntoEventFullEntity(nestedObjects, eventFullEntity);

            connection.commit();

            return eventFullEntity;
        } catch (SQLException exception) {
            try {
                this.dbConnection.getConnection().rollback();
            } catch (SQLException rollbackException) {
                this.logger.error(rollbackException.getMessage());
            }

            this.logger.error(exception.getMessage());
            return null;
        } finally {
            try {
                this.dbConnection.getConnection().setAutoCommit(true);
            } catch (SQLException exception) {
                this.logger.error(exception.getMessage());
            }
        }
    }

    private void getEventSubCategory (EventFullEntity eventFullEntity, Long eventId) {
        switch (eventFullEntity.getEventType()) {
            case ANNIVERSARIES -> eventFullEntity.setAnniversary(this.anniversaryRepository.getByEventId(eventId));
            case BIRTHDAY_PARTIES -> eventFullEntity.setBirthdayParty(this.birthdayPartyRepository.getByEventId(eventId));
            case GET_TOGETHER -> eventFullEntity.setGetTogether(this.getTogetherRepository.getByEventId(eventId));
            case WEDDING -> eventFullEntity.setWedding(this.weddingRepository.getByEventId(eventId));
        }
    }

    @Override
    public EventFullEntity get (Long id) {
        try (final ResultSet resultSet = this.dbConnection.execute("SELECT user_id, venue_id, location, event_date, start_time, end_time, event_type, head_count, total_price, budget_type, event_status FROM event WHERE id = ? AND is_deleted = FALSE", id)) {
            if (!resultSet.next()) return null;

            final EventFullEntity eventFullEntity = EventFullEntity.builder()
                    .id(id)
                    .location(resultSet.getString(3))
                    .eventDate(resultSet.getDate(4).toLocalDate())
                    .startTime(resultSet.getTime(5).toLocalTime())
                    .endTime(resultSet.getTime(6).toLocalTime())
                    .eventType(EventType.fromName(resultSet.getString(7)))
                    .headCount(resultSet.getInt(8))
                    .totalPrice(resultSet.getDouble(9))
                    .budgetType(BudgetType.fromName(resultSet.getString(10)))
                    .eventStatus(EventStatusType.fromName(resultSet.getString(11)))
                    .build();

            eventFullEntity.setUser(this.userRepository.findById(resultSet.getLong(1)).orElse(null));
            eventFullEntity.setVenue(this.venueRepository.findById(resultSet.getLong(2)).orElse(null));

            this.getEventSubCategory(eventFullEntity, id);

            switch (eventFullEntity.getEventType()) {
                case ANNIVERSARIES -> eventFullEntity.setAnniversary(this.anniversaryRepository.getByEventId(id));
                case BIRTHDAY_PARTIES -> eventFullEntity.setBirthdayParty(this.birthdayPartyRepository.getByEventId(id));
                case GET_TOGETHER -> eventFullEntity.setGetTogether(this.getTogetherRepository.getByEventId(id));
                case WEDDING -> eventFullEntity.setWedding(this.weddingRepository.getByEventId(id));
            }

            return eventFullEntity;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return null;
        }
    }

    private List<EventFullEntity> getListOfEventFullEntitiesByMatchQuery (String condition, Object ...binds) {
        final List<EventFullEntity> eventFullEntities = new ArrayList<>();

        try (final ResultSet resultSet = this.dbConnection.execute("SELECT id, user_id, venue_id, location, event_date, start_time, end_time, event_type, head_count, total_price, budget_type, event_status FROM event WHERE is_deleted = FALSE" + condition, binds)) {
            while (resultSet.next()) {
                final long id = resultSet.getLong(1);
                final EventFullEntity eventFullEntity = EventFullEntity.builder()
                        .id(id)
                        .location(resultSet.getString(4))
                        .eventDate(resultSet.getDate(5).toLocalDate())
                        .startTime(resultSet.getTime(6).toLocalTime())
                        .endTime(resultSet.getTime(7).toLocalTime())
                        .eventType(EventType.fromName(resultSet.getString(8)))
                        .headCount(resultSet.getInt(9))
                        .totalPrice(resultSet.getDouble(10))
                        .budgetType(BudgetType.fromName(resultSet.getString(11)))
                        .eventStatus(EventStatusType.fromName(resultSet.getString(12)))
                        .build();

                eventFullEntity.setUser(this.userRepository.findById(resultSet.getLong(2)).orElse(null));
                eventFullEntity.setVenue(this.venueRepository.findById(resultSet.getLong(3)).orElse(null));

                this.getEventSubCategory(eventFullEntity, id);

                switch (eventFullEntity.getEventType()) {
                    case ANNIVERSARIES -> eventFullEntity.setAnniversary(this.anniversaryRepository.getByEventId(id));
                    case BIRTHDAY_PARTIES -> eventFullEntity.setBirthdayParty(this.birthdayPartyRepository.getByEventId(id));
                    case GET_TOGETHER -> eventFullEntity.setGetTogether(this.getTogetherRepository.getByEventId(id));
                    case WEDDING -> eventFullEntity.setWedding(this.weddingRepository.getByEventId(id));
                }

                eventFullEntities.add(eventFullEntity);
            }
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
        }

        return eventFullEntities;
    }

    @Override
    public List<EventFullEntity> getAll () {
        return this.getListOfEventFullEntitiesByMatchQuery("");
    }

    @Override
    public List<EventFullEntity> getAllByDate (LocalDate date) {
        return this.getListOfEventFullEntitiesByMatchQuery(" WHERE event_date = ?", date);
    }

    @Override
    public List<EventFullEntity> getAllByLocation (Long locationId) {
        return this.getListOfEventFullEntitiesByMatchQuery(" WHERE location_id = ?", locationId);
    }

    @Override
    public List<EventFullEntity> getAllByUser (Long userId) {
        return this.getListOfEventFullEntitiesByMatchQuery(" WHERE user_id = ?", userId);
    }

    @Override
    @Transactional
    public boolean delete (Long id) {
        try {
            return (Integer) this.dbConnection.execute("UPDATE event SET is_deleted = TRUE WHERE id = ?", id) != 0;
        } catch (SQLException exception) {
            this.logger.error(exception.getMessage());
            return false;
        }
    }
}
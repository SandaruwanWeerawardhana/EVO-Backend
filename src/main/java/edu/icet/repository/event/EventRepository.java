package edu.icet.repository.event;

import edu.icet.entity.event.EventEntity;
import edu.icet.util.BudgetType;
import edu.icet.util.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity,Long> {

    List<EventEntity> findAllByEventType(EventType eventType);
    List<EventEntity> findAllByBudgetType(BudgetType budgetType);
    List<EventEntity> findAllByUserId(Long userId);
    List<EventEntity> findAllByEventDate(Date date);

    @Query("SELECT e FROM EventEntity e WHERE e.venue.id = ?1")
    List<EventEntity> findAllByVenueId(Long venueId);
}


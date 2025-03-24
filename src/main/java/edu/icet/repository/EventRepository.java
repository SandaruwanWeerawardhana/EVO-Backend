package edu.icet.repository;

import edu.icet.entity.EventEntity;
import edu.icet.util.BudgetType;
import edu.icet.util.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity,Long> {

    List<EventEntity> findAllByEventType(EventType eventType);
    List<EventEntity> findAllByBudgetType(BudgetType budgetType);
    List<EventEntity> findAllByUserId(Long userId);
    List<EventEntity> findAllByEventDate(Date date);
}


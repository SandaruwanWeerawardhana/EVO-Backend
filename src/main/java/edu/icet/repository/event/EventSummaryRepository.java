package edu.icet.repository.event;

import edu.icet.entity.event.EventSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventSummaryRepository extends JpaRepository<EventSummaryEntity, Integer> {
    List<EventSummaryEntity> findAllByCustomerId(Long customerId);
}

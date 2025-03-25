package edu.icet.repository.event;

import edu.icet.entity.event.EventSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSummaryRepository extends JpaRepository<EventSummaryEntity, Integer> {
}

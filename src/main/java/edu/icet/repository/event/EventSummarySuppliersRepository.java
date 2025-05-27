package edu.icet.repository.event;

import edu.icet.entity.event.EventSummaryEntity;
import edu.icet.entity.event.EventSummarySuppliersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventSummarySuppliersRepository extends JpaRepository<EventSummarySuppliersEntity, Long> {
    List<EventSummarySuppliersEntity> findAllByEventSummary(EventSummaryEntity eventSummary);

}

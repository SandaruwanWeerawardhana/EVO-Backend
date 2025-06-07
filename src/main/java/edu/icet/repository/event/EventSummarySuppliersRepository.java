package edu.icet.repository.event;

import edu.icet.entity.event.EventSummaryEntity;
import edu.icet.entity.event.EventSummarySuppliersEntity;
import edu.icet.entity.event.EventSupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventSummarySuppliersRepository extends JpaRepository<EventSummarySuppliersEntity, Long> {
    EventSummarySuppliersEntity findByEventSummary(EventSummaryEntity eventSummary);

    List<EventSupplierEntity> findByEventSummary(EventSummarySuppliersEntity event);

}

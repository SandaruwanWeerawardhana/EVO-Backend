package edu.icet.repository.event;

import edu.icet.entity.event.EventSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventSummaryRepository extends JpaRepository<EventSummaryEntity, Long> {

  @Query(value = "select  * from event_summary where customer_id = :customerId", nativeQuery = true)
  List<EventSummaryEntity> findAllByCustomerId(Long customerId);
}

package edu.icet.repository;

import edu.icet.entity.EventSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSummaryRepository extends JpaRepository<EventSummaryEntity, Integer> {
}

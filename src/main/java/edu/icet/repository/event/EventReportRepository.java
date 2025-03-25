package edu.icet.repository.event;

import edu.icet.entity.event.EventReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventReportRepository extends JpaRepository<EventReportEntity, Long> {
}

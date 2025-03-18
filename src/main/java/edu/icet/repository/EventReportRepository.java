package edu.icet.repository;

import edu.icet.entity.EventReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventReportRepository extends JpaRepository<EventReportEntity, Long> {
}

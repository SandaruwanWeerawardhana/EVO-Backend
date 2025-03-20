package edu.icet.repository;

import edu.icet.entity.AuditReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditReportRepository extends JpaRepository<AuditReportEntity,Long> {
}

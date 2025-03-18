package edu.icet.repository;

import edu.icet.entity.AuditHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditHistoryRepository extends JpaRepository<AuditHistoryEntity,Long> {
}

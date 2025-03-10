package edu.icet.service.admin;

import edu.icet.dto.AuditHistory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuditHistoryService {
    Boolean saveAuditHistory(AuditHistory auditHistory);
    List<AuditHistory> getAll();
    AuditHistory findById(Long id);
    Boolean deleteAuditHistory(Long id);


}

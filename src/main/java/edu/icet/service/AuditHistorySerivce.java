package edu.icet.service;

import edu.icet.dto.AuditHistory;

import java.util.List;

public interface AuditHistorySerivce {
    Boolean saveAuditHistory(AuditHistory auditHistory);
    List<AuditHistory> getAll();
    AuditHistory findById(Long id);
    Boolean deleteAuditHistory(Long id);


}

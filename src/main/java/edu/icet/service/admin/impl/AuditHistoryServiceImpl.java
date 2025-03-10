package edu.icet.service.admin.impl;

import edu.icet.dto.AuditHistory;
import edu.icet.service.admin.AuditHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuditHistoryServiceImpl implements AuditHistoryService {
    @Override
    public Boolean saveAuditHistory(AuditHistory auditHistory) {
        return null;
    }

    @Override
    public List<AuditHistory> getAll() {
        return List.of();
    }

    @Override
    public AuditHistory findById(Long id) {
        return null;
    }

    @Override
    public Boolean deleteAuditHistory(Long id) {
        return null;
    }
}

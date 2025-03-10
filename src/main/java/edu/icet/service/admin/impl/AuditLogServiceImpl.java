package edu.icet.service.admin.impl;

import edu.icet.dto.AuditLog;
import edu.icet.service.admin.AuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuditLogServiceImpl implements AuditLogService {
    @Override
    public boolean saveAuditLog(AuditLog auditLog) {
        return false;
    }

    @Override
    public AuditLog getAuditLogById(Long logId) {
        return null;
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return List.of();
    }

    @Override
    public boolean deleteAuditLog(Long logId) {
        return false;
    }
}

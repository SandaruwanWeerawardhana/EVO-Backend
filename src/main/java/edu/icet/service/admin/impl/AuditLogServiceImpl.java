package edu.icet.service.admin.impl;

import edu.icet.dto.AuditLog;
import edu.icet.service.admin.AuditLogService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class AuditLogServiceImpl implements AuditLogService {
    private final List<AuditLog> auditLogs = new ArrayList<>();
    @Override
    public boolean saveAuditLog(AuditLog auditLog) {
        if(auditLog != null && auditLog.getLogId() != null) {
            for (int i = 0; i < auditLogs.size(); i++) {
                if (auditLogs.get(i).getLogId().equals(auditLog.getLogId())) {
                    return false;
                }
            }
            auditLogs.add(auditLog);
            return true;
        }
        return false;
    }

    @Override
    public AuditLog getAuditLogById(Long logId) {
        if (logId == null) {
            return null;
        }
        for (int i=0; i<auditLogs.size(); i++) {
            if(auditLogs.get(i).getLogId().equals(logId)) {
                return auditLogs.get(i);
            }
        }
        return null;
    }

    @Override
    public List<AuditLog> getAllAuditLogs() {
        return new ArrayList<>(auditLogs);
    }

    @Override
    public boolean deleteAuditLog(Long logId) {
        if(logId == null) {
            return false;
        }
        for (int i=0; i <auditLogs.size(); i++) {
            if (auditLogs.get(i).getLogId().equals(logId)) {
                auditLogs.remove(i);
                return true;
            }
        }
        return false;
    }
}

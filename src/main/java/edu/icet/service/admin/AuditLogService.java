package edu.icet.service.admin;

import edu.icet.dto.AuditLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuditLogService {
   boolean saveAuditLog(AuditLog auditLog);
   AuditLog getAuditLogById(Long logId);
   List<AuditLog> getAllAuditLogs();
   boolean deleteAuditLog(Long logId);
}

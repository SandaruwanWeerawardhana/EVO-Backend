package edu.icet.service;

import edu.icet.dto.AuditLogDto;

import java.util.List;

public interface AuditLogService {
   void saveAuditLog(AuditLogDto auditLogDto);
   AuditLogDto getAuditLogById(Long logId);
   List<AuditLogDto> getAllAuditLogs();
   void deleteAuditLog(Long logId);
}

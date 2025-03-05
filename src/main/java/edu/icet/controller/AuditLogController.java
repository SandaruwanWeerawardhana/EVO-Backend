package edu.icet.controller;

import edu.icet.dto.AuditLog;
import edu.icet.service.AuditLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    final AuditLogService auditLogService;

    @Autowired
    public AuditLogController(AuditLogService auditLogService){
        this.auditLogService=auditLogService;
    }

    @PostMapping
    public ResponseEntity<String> saveAuditLog(@RequestBody AuditLog auditLog){
        boolean isSaved = auditLogService.saveAuditLog(auditLog);
        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Audit log saved successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the audit log.");
        }
    }

    @GetMapping("/{logId}")
    public ResponseEntity<AuditLog> getAuditLogById(@PathVariable Long logId){
        AuditLog auditLog =auditLogService.getAuditLogById(logId);
        return auditLog !=null?ResponseEntity.ok(auditLog):ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAuditLogs(){
        List<AuditLog> auditLogList =auditLogService.getAllAuditLogs();
        return auditLogList.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(auditLogList);
    }

    @DeleteMapping("/{logId}")
   public ResponseEntity<String> deleteAuditLog(@PathVariable Long logId){
        boolean isDeleted = auditLogService.deleteAuditLog(logId);
        if(isDeleted){
        return ResponseEntity.status(HttpStatus.OK).body("Audit log deleted successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Audit log not found.");
        }
    }
    }
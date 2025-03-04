package edu.icet.controller;

import edu.icet.dto.AuditLogDto;
import edu.icet.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<String> saveAuditLog(@RequestBody AuditLogDto auditLogDto){
        auditLogService.saveAuditLog(auditLogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Audit log saved successfully.");
    }

    @GetMapping("/{logId}")
    public ResponseEntity<AuditLogDto> getAuditLogById(@PathVariable Long logId){
        AuditLogDto auditLogDto=auditLogService.getAuditLogById(logId);
        return auditLogDto!=null?ResponseEntity.ok(auditLogDto):ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AuditLogDto>> getAllAuditLogs(){
        List<AuditLogDto> auditLogDtoList=auditLogService.getAllAuditLogs();
        return auditLogDtoList.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(auditLogDtoList);
    }

    @DeleteMapping("/{logId}")
   public ResponseEntity<String> deleteAuditLog(@PathVariable Long logId){
  AuditLogDto auditLogDto= auditLogService.getAuditLogById(logId);
  if(auditLogDto==null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Audit log not found");
  }else{
      auditLogService.deleteAuditLog(logId);
      return ResponseEntity.ok("Audit log deleted successfully");
  }
    }
}
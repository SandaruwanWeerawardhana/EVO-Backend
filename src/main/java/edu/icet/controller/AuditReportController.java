package edu.icet.controller;

import edu.icet.dto.AuditReport;
import edu.icet.service.admin.AuditReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/audit-report")
@RequiredArgsConstructor
public class AuditReportController {

    final AuditReportService service;

    @PostMapping("/add")
    public ResponseEntity<String> addAuditReport(@Valid @RequestBody AuditReport auditReport, HttpServletRequest request) {
        if (service.saveAuditReport(auditReport)) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Report detail: {}", os, auditReport);
            return ResponseEntity.ok(" Report saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added Report");
        }
    }

    @PutMapping("/update/{reportId}")
    public ResponseEntity<String> updateReport(@PathVariable Long reportId, @Valid @RequestBody AuditReport auditReport) {
        if (service.updateAuditReport(reportId, auditReport)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
        if (service.deleteAuditReportById(reportId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{reportId}")
    public ResponseEntity<AuditReport> searchReport(@PathVariable Long reportId) {
        AuditReport auditReport = service.getAuditReportById(reportId);
        if (auditReport != null) {
            return new ResponseEntity<>(auditReport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<AuditReport>> getAll() {
        List<AuditReport> auditReports = service.getAllAuditReports();
        if (auditReports != null) {
            return new ResponseEntity<>(auditReports, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

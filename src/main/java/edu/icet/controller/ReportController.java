package edu.icet.controller;

import edu.icet.dto.Report;
import edu.icet.service.ReportService;
import edu.icet.util.ReportType;
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
@RequestMapping("/report")
@RequiredArgsConstructor

public class ReportController {

    final ReportService service;

    @PostMapping("/add")
    public ResponseEntity<String> addReport(@Valid @RequestBody Report report, HttpServletRequest request) {
        if (service.saveReport(report)) {
            String os = request.getRemoteAddr();
            log.info("Request Received IP: {} | Add Report detail: {}", os, report);
            return ResponseEntity.ok(" Report saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("try again!, Can't added Report");
        }
    }


    @PutMapping("/update/{reportId}")
    public ResponseEntity<String> updateReport(@PathVariable Long reportId, @Valid @RequestBody Report report) {
        if (service.updateReport(reportId, report)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteReport(@PathVariable Long reportId) {
        if (service.deleteReportById(reportId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{reportId}")
    public ResponseEntity<Report> searchReport(@PathVariable Long reportId) {
        Report report = service.searchReport(reportId);
        if (report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Report>> getAll() {
        List<Report> allReports = service.getAllReports();
        if (allReports != null) {
            return new ResponseEntity<>(allReports, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Report>> getFilterReports(ReportType reportType) {
        List<Report> filterReports = service.getFillterReports(reportType);
        if (filterReports != null) {
            return new ResponseEntity<>(filterReports, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

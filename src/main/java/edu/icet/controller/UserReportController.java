package edu.icet.controller;

import edu.icet.dto.UserReport;
import edu.icet.repository.UserReportService;
import edu.icet.util.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user-reports")
public class UserReportController {

    private final UserReportService userReportService;

    public UserReportController(UserReportService userReportService) {
        this.userReportService = userReportService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Boolean> saveUserReport(@PathVariable Long id, @RequestBody UserReport userReport) {
        boolean saved = userReportService.saveUserReport(id, userReport);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReport> getUserReportById(@PathVariable Long id) {
        UserReport report = userReportService.getUserReportById(id);
        return ResponseEntity.ok(report);
    }

    @GetMapping
    public ResponseEntity<List<UserReport>> getAllUserReports() {
        List<UserReport> reports = userReportService.getAllUserReports();
        return ResponseEntity.ok(reports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReport> updateUserReport(@PathVariable Long id, @RequestBody UserReport userReport) {
        UserReport updatedReport = userReportService.updateUserReport(id, userReport);
        return ResponseEntity.ok(updatedReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserReport(@PathVariable Long id) {
        boolean deleted = userReportService.deleteUserReport(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/search/by-name")
    public ResponseEntity<List<UserReport>> findByName(@RequestParam String name) {
        List<UserReport> reports = userReportService.findByName(name);
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/search/by-user-type")
    public ResponseEntity<List<UserReport>> findByUserType(@RequestParam UserType userType) {
        List<UserReport> reports = userReportService.findByUserType(userType);
        return ResponseEntity.ok(reports);
    }
}

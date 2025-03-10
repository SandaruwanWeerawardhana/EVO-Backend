package edu.icet.controller;

import edu.icet.dto.AuditHistory;
import edu.icet.service.admin.AuditHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditHistory")
@RequiredArgsConstructor
@CrossOrigin
public class AuditHistoryController {

    final AuditHistoryService serivce;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Boolean> saveAuditHistory(@RequestBody AuditHistory auditHistory) {
        Boolean result = serivce.saveAuditHistory(auditHistory);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    ResponseEntity<List<AuditHistory>> getAll() {
        List<AuditHistory> all = serivce.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/find-by-id/{id}")
    ResponseEntity<AuditHistory> findById(@PathVariable Long id) {
        AuditHistory byId = serivce.findById(id);

        if (byId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<Boolean> deleteAuditHistory(@PathVariable Long id) {
        Boolean result = serivce.deleteAuditHistory(id);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
}

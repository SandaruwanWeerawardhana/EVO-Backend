package edu.icet.controller;

import edu.icet.dto.VerificationRequest;
import edu.icet.service.VerificationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verificationRequest")
@RequiredArgsConstructor
@CrossOrigin
public class VerificationRequestController {

    final VerificationRequestService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Boolean> saveVerificationRequest(@RequestBody VerificationRequest request) {
        boolean result = service.saveVerificationRequest(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/find-by-id/{id}")
    ResponseEntity<VerificationRequest> findVerificationRequestById(@PathVariable Long id) {
        VerificationRequest verificationRequest = service.findVerificationrequestById(id);
        if (verificationRequest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(verificationRequest);
    }

    @GetMapping("/get-all")
    ResponseEntity<List<VerificationRequest>> getAllVerificationRequest() {
        List<VerificationRequest> allVerificationRequest = service.getAllVerificationRequest();
        return ResponseEntity.ok(allVerificationRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<Boolean> deleteVerificationRequest(@PathVariable Long id) {
        boolean result = service.deleteVerificationRequest(id);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Boolean> updateVerificationRequest(@PathVariable Long id, @RequestBody VerificationRequest request) {
        boolean result = service.updateVerificationRequest(id, request);
        return ResponseEntity.ok(result);
    }
}
package edu.icet.controller;

import edu.icet.dto.Terms;
import edu.icet.service.TermsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier/terms")
@RequiredArgsConstructor
@CrossOrigin
public class TermsController {
    final TermsService termsService;

    @PostMapping("/add")
    public ResponseEntity<Terms> addTerms(@Valid @RequestBody Terms terms) {
        Terms createdTerms = termsService.addTerms(terms);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTerms);
    }

    @PutMapping("/update")
    public ResponseEntity<Terms> updateTerms(@Valid @RequestBody Terms terms) {
        Terms updatedTerms = termsService.updateTerms(terms);
        return ResponseEntity.ok(updatedTerms);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Terms> getTermsById(@PathVariable Integer id) {
        return termsService.getTermsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Terms>> getTermsByProfileId(@PathVariable Integer profileId) {
        List<Terms> termsList = termsService.getTermsByProfileId(profileId);
        return ResponseEntity.ok(termsList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTerms(@PathVariable Integer id) {
        termsService.deleteTerms(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/active/{profileId}")
    public ResponseEntity<Terms> getActiveTerms(@PathVariable Integer profileId) {
        return termsService.getActiveTerms(profileId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

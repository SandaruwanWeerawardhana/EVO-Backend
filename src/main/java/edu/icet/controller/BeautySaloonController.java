package edu.icet.controller;

import edu.icet.dto.BeautySaloon;
import edu.icet.service.supplier.BeautySaloonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beauty-saloons")
public class BeautySaloonController {

    private final BeautySaloonService beautySaloonService;

    @Autowired
    public BeautySaloonController(BeautySaloonService beautySaloonService) {
        this.beautySaloonService = beautySaloonService;
    }

    @PostMapping
    public ResponseEntity<String> addBeautySaloon(@Valid @RequestBody BeautySaloon beautySaloon) {
        beautySaloonService.add(beautySaloon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Beauty saloon added successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeautySaloon> getBeautySaloonById(@PathVariable String id) {
        BeautySaloon beautySaloon = beautySaloonService.get(id);
        return beautySaloon != null ? ResponseEntity.ok(beautySaloon) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BeautySaloon>> getAllBeautySaloons() {
        List<BeautySaloon> beautySaloons = beautySaloonService.getAll();
        return beautySaloons.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(beautySaloons);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBeautySaloon(@PathVariable String id) {
        boolean isDeleted = beautySaloonService.delete(id);
        return isDeleted
                ? ResponseEntity.ok("Beauty saloon deleted successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Beauty saloon not found.");
    }

    @PutMapping
    public ResponseEntity<String> updateBeautySaloon(@Valid @RequestBody BeautySaloon beautySaloon) {
        boolean isUpdated = beautySaloonService.update(beautySaloon);
        return isUpdated
                ? ResponseEntity.ok("Beauty saloon updated successfully.")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Beauty saloon not found.");
    }

    @GetMapping("/search")
    public ResponseEntity<List<BeautySaloon>> getBeautySaloonsByName(@RequestParam String name) {
        List<BeautySaloon> beautySaloons = beautySaloonService.getByName(name);
        return beautySaloons.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(beautySaloons);
    }
}

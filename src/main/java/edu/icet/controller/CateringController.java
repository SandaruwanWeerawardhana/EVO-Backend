package edu.icet.controller;

import edu.icet.dto.Catering;
import edu.icet.service.supplier.CateringService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/catering")
@RequiredArgsConstructor
@CrossOrigin
public class CateringController {
    final CateringService cateringService;

    @PostMapping("/add")
    public ResponseEntity<Catering> addCatering(@Valid @RequestBody Catering catering) {
        Catering createdCatering = cateringService.addCatering(catering);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCatering);
    }

    @PutMapping("/update")
    public ResponseEntity<Catering> updateCatering(@Valid @RequestBody Catering catering) {
        Catering updatedCatering = cateringService.updateCatering(catering);
        return ResponseEntity.ok(updatedCatering);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Catering> getCateringById(@PathVariable Integer id) {
        return cateringService.getCateringById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Catering>> getAllCatering() {
        List<Catering> cateringList = cateringService.getAllCatering();
        return ResponseEntity.ok(cateringList);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCatering(@PathVariable Integer id) {
        cateringService.deleteCatering(id);
        return ResponseEntity.ok("Catering service deleted successfully.");
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Catering>> getCateringBySupplierId(@PathVariable Integer supplierId) {
        List<Catering> cateringList = cateringService.getCateringBySupplierId(supplierId);
        return ResponseEntity.ok(cateringList);
    }
}

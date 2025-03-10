package edu.icet.controller;

import edu.icet.dto.TransactionHistory;
import edu.icet.service.admin.TransactionHistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/transactions/history")
@RequiredArgsConstructor
public class TransactionHistoryController {

    final TransactionHistoryService service;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveTransactionHistory(@Valid @RequestBody TransactionHistory history){
        TransactionHistory transactionHistory = service.save(history);
        return ResponseEntity.ok(transactionHistory==null);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<TransactionHistory>> getAllTransactionHistory(){
        List<TransactionHistory> all = service.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<TransactionHistory>getTransactionHistoryById(@PathVariable Long id){
        TransactionHistory transactionHistoryById = service.getTransactionHistoryById(id);
        return ResponseEntity.ok(transactionHistoryById);
    }
    @GetMapping("/byDate/{date}")
    public ResponseEntity<List<TransactionHistory>> getTransactionByDate(@PathVariable LocalDate date){
        List<TransactionHistory> transactionByDate = service.getTransactionByDate(date);
        return ResponseEntity.ok(transactionByDate);
    }
    @GetMapping("/byUserId/{id}")
    public ResponseEntity<List<TransactionHistory>> getTransactionByUserId(@PathVariable Long id){
        List<TransactionHistory> transactionByUserId = service.getTransactionByUserId(id);
        return ResponseEntity.ok(transactionByUserId);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteTransactionHistoryById(@PathVariable Long id){
        boolean b = service.deleteTransactionHistoryById(id);
        return ResponseEntity.ok(b);
    }
}
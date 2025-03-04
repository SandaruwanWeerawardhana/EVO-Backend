package edu.icet.service;

import edu.icet.dto.TransactionHistory;

import java.time.LocalDate;
import java.util.List;

public interface TransactionHistoryService {
    TransactionHistory save(TransactionHistory history);
    TransactionHistory getTransactionHistoryById(Long id);
    List<TransactionHistory> getAll();
    boolean deleteTransactionHistoryById(Long id);
    List<TransactionHistory> getTransactionByDate(LocalDate date);
    List<TransactionHistory> getTransactionByUserId(Long id);

}

package edu.icet.service.admin.impl;

import edu.icet.dto.TransactionHistory;
import edu.icet.service.admin.TransactionHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    @Override
    public TransactionHistory save(TransactionHistory history) {
        return null;
    }

    @Override
    public TransactionHistory getTransactionHistoryById(Long id) {
        return null;
    }

    @Override
    public List<TransactionHistory> getAll() {
        return List.of();
    }

    @Override
    public boolean deleteTransactionHistoryById(Long id) {
        return false;
    }

    @Override
    public List<TransactionHistory> getTransactionByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<TransactionHistory> getTransactionByUserId(Long id) {
        return List.of();
    }
}

package edu.icet.service.admin.impl;

import edu.icet.dto.TransactionHistory;
import edu.icet.service.admin.TransactionHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    private final List<TransactionHistory> transactionHistoryList = new ArrayList<>();

    @Override
    public TransactionHistory save(TransactionHistory history) {
        transactionHistoryList.add(history);
        return history;
    }

    @Override
    public TransactionHistory getTransactionHistoryById(Long id) {
        for (TransactionHistory transactionHistory : transactionHistoryList) {
            if (transactionHistory.getId().equals(id)) {
                return transactionHistory;
            }
        }
        return null;
    }

    @Override
    public List<TransactionHistory> getAll() {
        return new ArrayList<>(transactionHistoryList);
    }

    @Override
    public boolean deleteTransactionHistoryById(Long id) {
        return transactionHistoryList.removeIf(transaction -> transaction.getId().equals(id));
    }

    @Override
    public List<TransactionHistory> getTransactionByDate(LocalDate date) {
        List<TransactionHistory>result=new ArrayList<>();
        for (TransactionHistory transaction:transactionHistoryList){
            if (transaction.getDate().equals(date)){
                result.add(transaction);
            }
        }
        return result;
    }

    @Override
    public List<TransactionHistory> getTransactionByUserId(Long id) {
        List<TransactionHistory>result=new ArrayList<>();
        for (TransactionHistory transaction:transactionHistoryList){
            if (transaction.getId().equals(id)){
                result.add(transaction);
            }
        }
        return result;
    }
}

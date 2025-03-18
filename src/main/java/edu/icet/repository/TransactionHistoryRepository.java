package edu.icet.repository;

import edu.icet.entity.TransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity,Long> {
}

package edu.icet.repository;

import edu.icet.entity.SearchHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity,Long> {

}

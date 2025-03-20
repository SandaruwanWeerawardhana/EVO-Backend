package edu.icet.repository;

import edu.icet.entity.SearchHistoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistoryEntity,Long> {
    List<SearchHistoryEntity> findByTitle(String title);

/*    @Modifying
    @Transactional
    @Query("DELETE FROM SearchHistory sh WHERE sh.id IN (SELECT s.id FROM Customer c JOIN c.searchHistories s WHERE c.id = :customerId)")
    void deleteByCustomerId(@Param("customerId") Long customerId);*/

}

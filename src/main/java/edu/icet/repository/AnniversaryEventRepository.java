package edu.icet.repository;

import edu.icet.entity.AnniversaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnniversaryEventRepository extends JpaRepository<AnniversaryEntity,Long> {
}

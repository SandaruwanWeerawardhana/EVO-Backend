package edu.icet.repository.event;

import edu.icet.entity.event.AnniversaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnniversaryEventRepository extends JpaRepository<AnniversaryEntity,Long> {
}

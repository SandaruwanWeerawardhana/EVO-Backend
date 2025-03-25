package edu.icet.repository.event;

import edu.icet.entity.event.WeddingEntity;
import edu.icet.util.WeddingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeddingRepository extends JpaRepository<WeddingEntity,Long> {
    List<WeddingEntity> findByWeddingType(WeddingType weddingType);
    List<WeddingEntity> findByDate(LocalDate date);

}

package edu.icet.repository.supplier;

import edu.icet.entity.supplier.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<MusicEntity,Long> {
    List<MusicEntity> findBySupplierId(Long supplierId);
    List<MusicEntity>findByTeamSize(Integer teamSize);
}

package edu.icet.repository;

import edu.icet.entity.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MusicRepository extends JpaRepository<MusicEntity,Long> {
    List<MusicEntity> findBySupplierId(Long supplierId);
    List<MusicEntity>findByTeamSize(Integer teamSize);
}

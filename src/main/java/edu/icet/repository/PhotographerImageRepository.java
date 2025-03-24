package edu.icet.repository;

import edu.icet.entity.PhotographerImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographerImageRepository extends JpaRepository <PhotographerImageEntity, Long> {
}

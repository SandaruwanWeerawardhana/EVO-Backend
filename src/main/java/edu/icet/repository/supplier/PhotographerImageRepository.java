package edu.icet.repository.supplier;

import edu.icet.entity.supplier.PhotographerImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographerImageRepository extends JpaRepository <PhotographerImageEntity, Long> {
}

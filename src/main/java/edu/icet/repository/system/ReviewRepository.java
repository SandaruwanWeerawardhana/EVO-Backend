package edu.icet.repository.system;

import edu.icet.entity.system.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
}

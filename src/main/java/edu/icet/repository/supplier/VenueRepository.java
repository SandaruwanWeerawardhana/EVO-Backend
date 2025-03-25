package edu.icet.repository.supplier;

import edu.icet.entity.supplier.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<VenueEntity,Long> {
}

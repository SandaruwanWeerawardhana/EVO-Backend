package edu.icet.repository;

import edu.icet.dto.Venue;
import edu.icet.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<VenueEntity,Long> {
    Venue findByName(String name);
}

package edu.icet.repository;

import edu.icet.entity.VenueRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VenueRequestRepository extends JpaRepository<VenueRequestEntity, Long> {
    List<VenueRequestEntity> findBySupplierId(Long supplierId);
    List<VenueRequestEntity> findByVenueID(Long venueID);
    List<VenueRequestEntity> findByStatus(String status);
}
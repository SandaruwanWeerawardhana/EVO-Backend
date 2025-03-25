package edu.icet.repository.supplier;

import edu.icet.entity.supplier.HallEntity;
import edu.icet.util.HallAvailabilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallReopsitory extends JpaRepository<HallEntity,Long> {
    List<HallEntity> findByPropertyId(Long propertyId);
    List<HallEntity> findByCountGreaterThanEqual(Integer count);
    List<HallEntity> findByAvailability(HallAvailabilityType availability);

}

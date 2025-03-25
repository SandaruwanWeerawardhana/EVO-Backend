package edu.icet.repository.supplier;

import edu.icet.entity.supplier.CateringEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CateringRepository extends JpaRepository <CateringEntity, Integer>  {
    List<CateringEntity> findBySupplierId(Integer supplierId);
    List<CateringEntity> findByAvailabilityStatus(String availabilityStatus);
    List<CateringEntity> findBySupplierIdAndAvailabilityStatus(Integer supplierId, String availabilityStatus);
}

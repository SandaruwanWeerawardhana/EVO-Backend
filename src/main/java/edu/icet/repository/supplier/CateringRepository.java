package edu.icet.repository.supplier;

import edu.icet.entity.supplier.CateringEntity;
import edu.icet.entity.supplier.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CateringRepository extends JpaRepository <CateringEntity, Integer>  {
//    List<CateringEntity> findBySupplier(SupplierEntity supplier);
//    List<CateringEntity> findByAvailabilityStatus(String availabilityStatus);
//    List<CateringEntity> findBySupplierAndAvailabilityStatus(SupplierEntity supplier, String availabilityStatus);
}

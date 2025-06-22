package edu.icet.repository.supplier;

import edu.icet.entity.supplier.SupplierExtraFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SupplierExtraFeatureRepository extends JpaRepository<SupplierExtraFeatureEntity, Long> {
    Optional<SupplierExtraFeatureEntity> findBySupplierId(Long supplierId);
}

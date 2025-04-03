package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfilePackageEntity;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.util.SupplierCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findAllByCategory(SupplierCategoryType category);
    boolean existsByBusinessName(String name);
    boolean existsByBusinessEmail(String email);
    boolean existsByBusinessContactNumber(String phoneNumber);
    SupplierEntity findByPackagesIn(List<ProfilePackageEntity> packages);
}

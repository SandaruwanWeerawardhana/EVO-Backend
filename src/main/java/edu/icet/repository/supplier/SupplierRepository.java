package edu.icet.repository.supplier;

import edu.icet.dto.supplier.ProfilePackage;
import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.ProfilePackageEntity;
import edu.icet.entity.supplier.SupplierEntity;

import edu.icet.util.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findAllByCategory(CategoryType category);
    boolean existsByContactNumber(String contactNumber);
    boolean existsByBusinessName(String name);
    boolean existsByBusinessEmail(String email);
    boolean existsByBusinessContactNumber(String phoneNumber);
    SupplierEntity findByPackagesIn(List<ProfilePackageEntity> packages);
}

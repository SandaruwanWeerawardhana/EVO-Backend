package edu.icet.repository.supplier;

import edu.icet.entity.customer.CustomerEntity;
import edu.icet.entity.supplier.ProfilePackageEntity;
import edu.icet.entity.supplier.SupplierEntity;

import edu.icet.util.CategoryType;
import edu.icet.util.SupplierCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    Optional<CustomerEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}

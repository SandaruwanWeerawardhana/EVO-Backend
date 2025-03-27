package edu.icet.repository.supplier;

import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.util.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findAllByCategory(CategoryType category);
    boolean existsByEmail(String email);
    boolean existsByContactNumber(String contactNumber);
    boolean existsByBusinessName(String name);

}

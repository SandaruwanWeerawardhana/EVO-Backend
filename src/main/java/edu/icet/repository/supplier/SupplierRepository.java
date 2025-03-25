package edu.icet.repository.supplier;

import edu.icet.entity.supplier.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findAllByCategoryIdEquals(Long categoryId);
    boolean existsByEmail(String email);
    boolean existsByNumber(String number);
    boolean existsBusinessName(String name);

}

package edu.icet.repository;

import edu.icet.entity.SupplierEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
    List<SupplierEntity> findAllByCategoryIdEquals(Long categoryId);
}

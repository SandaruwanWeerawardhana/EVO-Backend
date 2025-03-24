package edu.icet.repository;

import edu.icet.entity.MealEntity;
import edu.icet.entity.MessageCustomerSupplierEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MessageCustomerSupplierRepository  extends JpaRepository<MessageCustomerSupplierEntity, Long> {
    List<MessageCustomerSupplierEntity> findBySupplierId(Long supplierId);

    List<MessageCustomerSupplierEntity> findByCustomerId(Long customerId);

    List<MessageCustomerSupplierEntity> findByCustomerIdAndSupplierId(Long customerId, Long supplierId);
}

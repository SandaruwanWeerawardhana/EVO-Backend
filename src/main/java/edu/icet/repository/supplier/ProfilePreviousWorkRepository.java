package edu.icet.repository.supplier;

import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.entity.supplier.ProfilePreviousWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ProfilePreviousWorkRepository extends JpaRepository<ProfilePreviousWorkEntity,Long> {

    ProfilePreviousWorkEntity findBySupplier(Supplier supplier);
    ProfilePreviousWorkEntity findByPreviousWorkID(Long id);
    ProfilePreviousWorkEntity findByCustomer(CustomerEntity customer);
    ProfilePreviousWorkEntity findByCompletionDateAfter(LocalDate date);
    ProfilePreviousWorkEntity findByCompletionDateBefore(LocalDate date);
}

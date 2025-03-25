package edu.icet.repository.supplier;

import edu.icet.entity.supplier.ProfilePreviousWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ProfilePreviousWorkRepository extends JpaRepository<ProfilePreviousWorkEntity,Long> {

    ProfilePreviousWorkEntity findByProfileID(Long profileID);
    ProfilePreviousWorkEntity findByPreviousWorkID(Long id);
    ProfilePreviousWorkEntity findByCustomerID(Long customerID);
    ProfilePreviousWorkEntity findByCompletionDateAfter(LocalDate date);
    ProfilePreviousWorkEntity findByCompletionDateBefore(LocalDate date);
}

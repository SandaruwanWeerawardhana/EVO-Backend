package edu.icet.repository;

import edu.icet.entity.ProfilePreviousWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProfilePreviousWorkRepository extends JpaRepository<ProfilePreviousWorkEntity,Long> {

    ProfilePreviousWorkEntity findByProfileID(Long profileID);
    ProfilePreviousWorkEntity findByPreviousWorkID(Long id);
    ProfilePreviousWorkEntity findByCustomerID(Long customerID);
    ProfilePreviousWorkEntity findByCompletionDateAfter(LocalDate date);
    ProfilePreviousWorkEntity findByCompletionDateBefore(LocalDate date);
}

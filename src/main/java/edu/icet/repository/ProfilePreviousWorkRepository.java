package edu.icet.repository;

import edu.icet.entity.ProfilePreviousWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProfilePreviousWorkRepository extends JpaRepository<ProfilePreviousWorkEntity,Long> {

    List<ProfilePreviousWorkEntity> findByProfileID(Long profileID);
    List<ProfilePreviousWorkEntity> findByCustomerID(Long customerID);
    List<ProfilePreviousWorkEntity> findByCompletionDateAfter(LocalDate date);
    List<ProfilePreviousWorkEntity> findByCompletionDateBefore(LocalDate date);
}

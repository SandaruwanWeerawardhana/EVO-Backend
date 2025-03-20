package edu.icet.repository;

import edu.icet.entity.VerificationRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRequestRepository extends JpaRepository<VerificationRequestEntity, Long> {
}

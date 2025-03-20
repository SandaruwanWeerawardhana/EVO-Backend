package edu.icet.repository;

import edu.icet.entity.BirthdayPartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayPartyRepository extends JpaRepository<BirthdayPartyEntity, Integer> {
}

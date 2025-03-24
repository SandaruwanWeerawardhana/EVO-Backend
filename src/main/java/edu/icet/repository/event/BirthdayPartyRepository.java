package edu.icet.repository.event;

import edu.icet.entity.event.BirthdayPartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayPartyRepository extends JpaRepository<BirthdayPartyEntity, Long> {
}

package edu.icet.repository;

import edu.icet.entity.BookingSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSlotRepository extends JpaRepository<BookingSlotEntity,Long> {
}

package edu.icet.repository.supplier;

import edu.icet.entity.supplier.BookingSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingSlotRepository extends JpaRepository<BookingSlotEntity,Long> {

    List<BookingSlotEntity> findByPropertyIdAndStartTimeAndEndTime(Long propertyId, LocalDateTime startTime, LocalDateTime endTime);

}

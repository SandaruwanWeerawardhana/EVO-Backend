package edu.icet.service;

import edu.icet.dto.BookingSlot;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingSlotService {

    List<BookingSlot> getAll();
    BookingSlot save(BookingSlot bookingSlot);
    Boolean delete(Long id);
    BookingSlot update(BookingSlot bookingSlot);
    List<BookingSlot> search(Long propertyId, LocalDateTime startTime, LocalDateTime endTime);
}

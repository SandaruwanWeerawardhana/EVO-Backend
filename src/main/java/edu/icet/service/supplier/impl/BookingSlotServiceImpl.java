package edu.icet.service.supplier.impl;

import edu.icet.dto.BookingSlot;
import edu.icet.service.supplier.BookingSlotService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BookingSlotServiceImpl implements BookingSlotService {
    @Override
    public List<BookingSlot> getAll() {
        return List.of();
    }

    @Override
    public BookingSlot save(BookingSlot bookingSlot) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public BookingSlot update(BookingSlot bookingSlot) {
        return null;
    }

    @Override
    public List<BookingSlot> search(Long propertyId, LocalDateTime startTime, LocalDateTime endTime) {
        return List.of();
    }
}

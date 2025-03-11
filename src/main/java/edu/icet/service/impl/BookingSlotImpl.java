package edu.icet.service.impl;

import edu.icet.dto.BookingSlot;
import edu.icet.service.BookingSlotService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookingSlotImpl implements BookingSlotService {
    final ModelMapper mapper;

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

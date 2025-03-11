package edu.icet.service.supplier.impl;

import edu.icet.dto.BookingSlot;
import edu.icet.service.supplier.BookingSlotService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingSlotServiceImpl implements BookingSlotService {
    final ModelMapper mapper;
    private  final ArrayList<BookingSlot> bookingSlots = new ArrayList<>();
    @Override
    public List<BookingSlot> getAll() {
        return bookingSlots;
    }
    @Override
    public BookingSlot save(BookingSlot bookingSlot) {
        bookingSlots.add(bookingSlot);
        return bookingSlot;
    }

    @Override
    public Boolean delete(Long id) {
        bookingSlots.removeIf(bookingSlot -> bookingSlot.getBookingSlotId().equals(id));
        return bookingSlots.isEmpty();
    }
    @Override
    public BookingSlot update(BookingSlot bookingSlot) {
        if (bookingSlot == null || bookingSlot.getBookingSlotId() == null) return null;

        for (BookingSlot bs : bookingSlots) {
            if (bs.getBookingSlotId().equals(bookingSlot.getBookingSlotId())) {
                int index = bookingSlots.indexOf(bs);
                bookingSlots.set(index, bookingSlot);
                return bookingSlot;
            }
        }
        return null;
    }
    @Override
    public List<BookingSlot> search(Long propertyId, LocalDateTime startTime, LocalDateTime endTime) {
        List<BookingSlot> result = new ArrayList<>();
        for (BookingSlot bs : bookingSlots) {
            if (bs.getPropertyId().equals(propertyId) &&
                    !bs.getStartTime().isBefore(startTime) &&
                    !bs.getEndTime().isAfter(endTime)) {
                result.add(bs);
            }
        }
        return result;
    }
}

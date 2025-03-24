package edu.icet.service.supplier.impl;

import edu.icet.dto.BookingSlot;
import edu.icet.entity.BookingSlotEntity;
import edu.icet.repository.BookingSlotRepository;
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
    final private ModelMapper mapper;
    final private BookingSlotRepository repository;
    @Override
    public List<BookingSlot> getAll() {
        return repository.findAll()
                .stream()
                .map(bookingSlotEntity -> mapper.map(bookingSlotEntity, BookingSlot.class))
                .toList();
    }
    @Override
    public BookingSlot save(BookingSlot bookingSlot) {
        return mapper.map(repository.save(mapper.map(bookingSlot, BookingSlotEntity.class)), BookingSlot.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
    @Override
    public BookingSlot update(BookingSlot bookingSlot) {
        if (repository.existsById(bookingSlot.getBookingSlotId())) {
            return mapper.map(repository.save(mapper.map(bookingSlot, BookingSlotEntity.class)), BookingSlot.class);
        }

        return null;
    }
    @Override
    public List<BookingSlot> search(Long propertyId, LocalDateTime startTime, LocalDateTime endTime) {
        return repository.findByPropertyIdAndStartTimeAndEndTime(propertyId, startTime, endTime)
                .stream()
                .map(bookingSlotEntity -> mapper.map(bookingSlotEntity, BookingSlot.class))
                .toList();
    }
}

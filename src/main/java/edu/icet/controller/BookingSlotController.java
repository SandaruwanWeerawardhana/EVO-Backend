package edu.icet.controller;

import edu.icet.dto.BookingSlot;
import edu.icet.service.BookingSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/bookingslot")
@RequiredArgsConstructor
@CrossOrigin
public class BookingSlotController {
    final BookingSlotService bookingSlotService;

    @PostMapping("/add")
    public void add(@RequestBody BookingSlot bookingSlot) {
        bookingSlotService.save(bookingSlot);
    }

    @GetMapping("/getAll")
    public List<BookingSlot> getAll() {
        return bookingSlotService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable Long id) {
        bookingSlotService.delete(id);
    }

    @PutMapping("/update-bookingSlot")
    public void update(@RequestBody BookingSlot bookingSlot){
        bookingSlotService.update(bookingSlot);
    }
}

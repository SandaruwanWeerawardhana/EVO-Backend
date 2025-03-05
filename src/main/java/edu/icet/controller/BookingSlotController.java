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
    public BookingSlot add(@RequestBody BookingSlot bookingSlot) {
        return bookingSlotService.save(bookingSlot);
    }

    @GetMapping("/getAll")
    public List<BookingSlot> getAll() {
        return bookingSlotService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean Delete(@PathVariable Long id) {
        return bookingSlotService.delete(id);
    }

    @PutMapping("/update-bookingSlot")
    public BookingSlot update(@RequestBody BookingSlot bookingSlot){
       return bookingSlotService.update(bookingSlot);
    }
}

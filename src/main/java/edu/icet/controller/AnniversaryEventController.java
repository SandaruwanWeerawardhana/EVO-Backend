package edu.icet.controller;

import edu.icet.dto.Anniversary;
import edu.icet.service.customer.AnniversaryEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anniversary")
@RequiredArgsConstructor
@CrossOrigin
public class AnniversaryEventController {

   private final AnniversaryEventService anniversaryEventService;

    @PostMapping("/save")
    public boolean addAnniversary(@RequestBody Anniversary anniversary) {
        return anniversaryEventService.add(anniversary);
    }

    @GetMapping("/get-all")
    public List<Anniversary> getAllAnniversaries() {
        return anniversaryEventService.getAll();
    }

    @GetMapping("/get/{eventId}")
    public Anniversary getAnniversary(@PathVariable("eventId") Integer eventId) {
        return anniversaryEventService.get(eventId);
    }

    @PutMapping("/update")
    public boolean updateAnniversary(@RequestBody Anniversary anniversary) {
        return anniversaryEventService.update(anniversary);
    }

    @DeleteMapping("/delete/{eventId}")
    public boolean deleteAnniversary(@PathVariable("eventId") Integer eventId) {
       return anniversaryEventService.delete(eventId);
    }
}







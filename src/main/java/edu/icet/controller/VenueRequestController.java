package edu.icet.controller;

import edu.icet.dto.Venue;
import edu.icet.service.VenueRequestService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/venue")
public class VenueRequestController {

    private VenueRequestService venueRequestService;

    @PostMapping("/add")
    Venue create(@RequestBody Venue venue) {
        return venueRequestService.create(venue);
    }

    @GetMapping("/get all")
    public List<Venue> getAllVenues() {
        return venueRequestService.getAllVenues();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        venueRequestService.delete(id);
    }

    @PutMapping("/update/{id}")
    Venue update(@PathVariable Long id,@RequestBody Venue venue) {
        return venueRequestService.update(id,venue);
    }

    @GetMapping("/search/{id}")
    Venue getVenueById(@PathVariable Long id) {
        return venueRequestService.getVenueById(id);
    }

}

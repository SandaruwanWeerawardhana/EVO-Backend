package edu.icet.controller;

import edu.icet.dto.Venue;
import edu.icet.service.VenueRequestService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/venue")
@RequiredArgsConstructor
public class VenueRequestController {


    private final VenueRequestService venueRequestService;

    @PostMapping("/add")
    Venue create(@RequestBody Venue venue) {
        return venueRequestService.create(venue);
    }

    @GetMapping("/get-all")
    public List<Venue> getAllVenues() {
        return venueRequestService.getAllVenues();
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable("id") Long id) {
        return venueRequestService.delete(id);
    }

    @PutMapping("/update/{id}")
    boolean update(@RequestBody Venue venue) {
        return venueRequestService.update(venue.getId(), venue);
    }


    @GetMapping("/search/{id}")
    Venue getVenueById(@PathVariable Long id) {
        return venueRequestService.getVenueById(id);
    }
}

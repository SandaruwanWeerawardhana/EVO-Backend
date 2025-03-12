package edu.icet.controller;

import edu.icet.dto.Venue;
import edu.icet.dto.VenueRequest;
import edu.icet.service.system.VenueRequestService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/supplier/venue/request")
@RequiredArgsConstructor
public class VenueRequestController {

    private final VenueRequestService venueRequestService;

    @PostMapping("/add")
    public VenueRequest addVenueRequest(@RequestBody VenueRequest venueRequest) {
        return venueRequestService.save(venueRequest);
    }

    @GetMapping("/getAll")
    public List<VenueRequest> getAllVenueRequests() {
        return venueRequestService.getAll();
    }

    @GetMapping("/search/{id}")
    public VenueRequest searchById(@PathVariable("id") Long id) {
        return venueRequestService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteVenueRequest(@PathVariable("id") Long id) {
        return venueRequestService.delete(id);
    }

    @PutMapping("/update")
    public VenueRequest updateVenueRequest(@RequestBody VenueRequest venueRequest) {
        return venueRequestService.update(venueRequest);
    }

}

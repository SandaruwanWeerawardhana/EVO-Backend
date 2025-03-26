package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Venue;
import edu.icet.dto.supplier.VenueRequest;
import edu.icet.service.system.VenueRequestService;
import edu.icet.util.EventType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/supplier/venue/request")
@RequiredArgsConstructor
public class VenueRequestController {

    private final VenueRequestService venueRequestService;

    @PostMapping("/add")
    public VenueRequest addVenueRequest(@Valid @RequestBody VenueRequest venueRequest) {
        return venueRequestService.save(venueRequest);
    }

    @GetMapping("/getAll")
    public Map<List<VenueRequest>,List<Venue>> getAllVenueRequests() {
        return venueRequestService.getAll();
    }

    @GetMapping("/search/{id}")
    public Map<VenueRequest,Venue> searchById(@Valid @PathVariable("id") Long id) {
        return venueRequestService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteVenueRequest(@Valid @PathVariable("id") Long id) {
        return venueRequestService.delete(id);
    }

    @PutMapping("/update")
    public VenueRequest updateVenueRequest(@Valid @RequestBody VenueRequest venueRequest) {
        return venueRequestService.update(venueRequest);
    }

    @GetMapping("/get-all-visible-venues")
    public List<Venue> getAllVisibleVenues() {
        return venueRequestService.getAllVisibleVenues();
    }

    @GetMapping("/get-all-visible-venues-by-location/{location}")
    public List<Venue> getAllVisibleVenuesByLocation(@PathVariable String location) {
        return venueRequestService.getAllVisibleVenuesByLocation(location);
    }

    @GetMapping("/get-all-visible-venues-by-eventType/{eventType}")
    public List<Venue> getAllVisibleVenuesByEventType(@PathVariable EventType eventType) {
        return venueRequestService.getAllVisibleVenuesByEventType(eventType);
    }

}

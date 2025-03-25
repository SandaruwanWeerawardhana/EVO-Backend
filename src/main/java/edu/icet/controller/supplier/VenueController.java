package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Venue;
import edu.icet.service.supplier.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("supplier/venue")

public class VenueController {

    final VenueService service;

    @PostMapping("/save")
    public void saveVenue(@RequestBody Venue venue){
        service.save(venue);
    }

    @GetMapping("/get-all")
    public List<Venue> getVenueData(){
        return service.getAll();
    }

    @GetMapping("/search")
    public Venue searchVenue(@PathVariable Long id){
        return service.search(id);
    }

    @PutMapping("/update")
    public Venue updateVenue(@RequestBody Venue venue){
        return service.update(venue);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteVenueById(@RequestParam Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody Venue venue){
        return service.delete(venue);
    }
}

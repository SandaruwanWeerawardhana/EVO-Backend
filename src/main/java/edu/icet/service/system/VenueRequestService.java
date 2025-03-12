package edu.icet.service.system;

import edu.icet.dto.Venue;
import edu.icet.dto.VenueRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VenueRequestService {
    VenueRequest save(VenueRequest venueRequest);
    List<VenueRequest> getAll();
    VenueRequest getById(Long id);
    boolean delete(Long id);
    VenueRequest update(VenueRequest venueRequest);
}

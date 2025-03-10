package edu.icet.service.system;

import edu.icet.dto.Venue;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VenueRequestService {

    Venue create(Venue venue);

    Venue getVenueById(Long id);

    List<Venue> getAllVenues();

    boolean update(Long id,Venue venue);

    boolean delete(Long id);
}

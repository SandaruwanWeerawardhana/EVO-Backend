package edu.icet.service.supplier;

import edu.icet.dto.supplier.Venue;

import java.util.List;

public interface VenueService {

    List<Venue> getAll();

    Venue save(Venue venue);

    Boolean delete(Venue venue);

    Boolean delete(Long id);

    Venue update(Venue venue);

    Venue search(Long id);

    Venue findById(Long venueID);

    Venue findByEventType(Long venueID);

}

package edu.icet.service;

import edu.icet.dto.Venue;

import java.util.List;

public interface VenueRequestService {

    Venue create(Venue venue);

    Venue getVenueById(Long id);

    List<Venue> getAllVenues();

    Venue update(Long id,Venue venue);

    void delete(Long id);
}

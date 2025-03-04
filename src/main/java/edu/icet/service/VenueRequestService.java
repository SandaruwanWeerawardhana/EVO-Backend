package edu.icet.service;

import edu.icet.dto.Venue;

import java.util.List;

public interface VenueRequestService {

    Venue createVenueRequest(Venue venue);

    Venue getVenueById(Long id);

    List<Venue> getAllVenues();

    Venue updateVenueRequest(Long id,Venue venue);

    void deleteVenueRequest(Long id);
}

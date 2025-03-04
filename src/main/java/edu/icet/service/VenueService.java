package edu.icet.service;

import edu.icet.dto.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> getAll();
    Boolean delete(Venue venue);
    Boolean delete(Long id);
    Venue update(Venue venue);
    Venue search(String quarey);
}

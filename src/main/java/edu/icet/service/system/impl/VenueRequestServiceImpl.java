package edu.icet.service.system.impl;

import edu.icet.dto.Venue;
import edu.icet.service.system.VenueRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VenueRequestServiceImpl implements VenueRequestService {
    @Override
    public Venue create(Venue venue) {
        return null;
    }

    @Override
    public Venue getVenueById(Long id) {
        return null;
    }

    @Override
    public List<Venue> getAllVenues() {
        return List.of();
    }

    @Override
    public boolean update(Long id, Venue venue) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

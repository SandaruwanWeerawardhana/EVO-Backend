package edu.icet.service.system.impl;

import edu.icet.dto.Venue;
import edu.icet.service.system.VenueRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VenueRequestServiceImpl implements VenueRequestService {
    private final List<Venue> venueList = new ArrayList<>();

    @Override
    public Venue create(Venue venue) {
        venueList.add(venue);
        return venue;
    }

    @Override
    public Venue getVenueById(Long id) {
        for (Venue venue : venueList){
            if (venue.getId().equals(id)){
                return venue;
            }
        }
        return null;
    }

    @Override
    public List<Venue> getAllVenues() {
        return new ArrayList<>(venueList);
    }

    @Override
    public boolean update(Long id, Venue venue) {
        for (int a=0; a < venueList.size(); a++) {
            if (venueList.get(a).getId().equals(id)) {
                venue.setId(id);
                venueList.set(a, venue);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return venueList.removeIf(venue -> venue.getId().equals(id));
    }
}

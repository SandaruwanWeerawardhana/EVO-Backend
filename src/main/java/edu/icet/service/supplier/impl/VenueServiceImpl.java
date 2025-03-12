package edu.icet.service.supplier.impl;

import edu.icet.dto.Venue;
import edu.icet.service.supplier.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class VenueServiceImpl implements VenueService {
    private final List<Venue> venueList = new ArrayList<>();

    @Override
    public List<Venue> getAll() {
        return new ArrayList<>(venueList);
    }

    @Override
    public Venue save(Venue venue) {
        venueList.add(venue);
        return venue;
    }

    @Override
    public Boolean delete(Venue venue) {
        return venueList.removeIf(venue1 -> venue1.equals(venue));
    }

    @Override
    public Boolean delete(Long id) {
        return venueList.removeIf(venue -> venue.getVenueId().equals(id));
    }

    @Override
    public Venue update(Venue venue) {
        for (Venue venue1 : venueList) {
            if(venue!=null) {
                venue1.setVenueId(venue.getVenueId());
                venue1.setSupplierId(venue.getSupplierId());
                venue1.setLocation(venue.getLocation());
                venue1.setEventType(venue.getEventType());
            }
        }
        return null;
    }

    @Override
    public Venue search(Long id){
        for (Venue venue : venueList) {
            if (venue.getVenueId().equals(id) || venue.getSupplierId().equals(id)) {
                return venue;
            }
        }
        return null;
    }

    public Venue search(String sr){
        for (Venue venue : venueList) {
            if (venue.getLocation().equals(sr)) {
                return venue;
            }
        }
        return null;
    }
}

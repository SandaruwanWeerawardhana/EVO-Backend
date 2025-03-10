package edu.icet.service.supplier.impl;

import edu.icet.dto.Venue;
import edu.icet.service.supplier.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VenueServiceImpl implements VenueService {
    @Override
    public List<Venue> getAll() {
        return List.of();
    }

    @Override
    public Venue save(Venue venue) {
        return null;
    }

    @Override
    public Boolean delete(Venue venue) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Venue update(Venue venue) {
        return null;
    }

    @Override
    public Venue search(String quarey) {
        return null;
    }
}

package edu.icet.service.system.impl;

import edu.icet.dto.Venue;
import edu.icet.dto.VenueRequest;
import edu.icet.service.system.VenueRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VenueRequestServiceImpl implements VenueRequestService {

    private final List<VenueRequest> venueRequests = new ArrayList<>();
    private ModelMapper modelMapper;

    @Override
    public VenueRequest save(VenueRequest venueRequest) {
        venueRequests.add(venueRequest);
        return venueRequest;
    }

    @Override
    public List<VenueRequest> getAll() {
        return new ArrayList<>(venueRequests);
    }

    @Override
    public VenueRequest getById(Long id) {
        return venueRequests.stream()
                .filter(request -> request.getVenueRequestID().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        return venueRequests.removeIf(request -> request.getVenueRequestID().equals(id));
    }

    @Override
    public VenueRequest update(VenueRequest venueRequest) {
        for (int i = 0; i < venueRequests.size(); i++) {
            if (venueRequests.get(i).getVenueRequestID().equals(venueRequest.getVenueRequestID())) {
                venueRequests.set(i, venueRequest);
                return venueRequest;
            }
        }
        return null;
    }
}

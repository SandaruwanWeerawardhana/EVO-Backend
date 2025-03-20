package edu.icet.service.system.impl;

import edu.icet.dto.VenueRequest;
import edu.icet.entity.VenueRequestEntity;
import edu.icet.repository.VenueRequestRepository;
import edu.icet.service.system.VenueRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class VenueRequestServiceImpl implements VenueRequestService {

    private final VenueRequestRepository venueRequestRepository;
    private ModelMapper mapper;

    @Override
    public VenueRequest save(VenueRequest venueRequest) {
        return mapper.map(venueRequestRepository.save(mapper.map(venueRequest, VenueRequestEntity.class)),VenueRequest.class);
    }

    @Override
    public List<VenueRequest> getAll() {
        List<VenueRequestEntity> all = venueRequestRepository.findAll();

        List<VenueRequest> venueRequestList = new ArrayList<>();

        all.forEach(venueRequestEntity -> {
            venueRequestList.add(mapper.map(venueRequestEntity,VenueRequest.class));
        });
        return venueRequestList;
    }

    @Override
    public VenueRequest getById(Long id) {
        return mapper.map(venueRequestRepository.findByVenueID(id),VenueRequest.class);
    }

    @Override
    public boolean delete(Long id) {
        if (venueRequestRepository.existsById(id)){
            venueRequestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public VenueRequest update(VenueRequest venueRequest) {
        return mapper.map(venueRequestRepository.save(mapper.map(venueRequest,VenueRequestEntity.class)),VenueRequest.class);
    }
}

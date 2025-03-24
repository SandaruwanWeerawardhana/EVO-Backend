package edu.icet.service.system.impl;

import edu.icet.dto.supplier.VenueRequest;
import edu.icet.entity.supplier.VenueRequestEntity;
import edu.icet.repository.supplier.VenueRequestRepository;
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
        List<VenueRequest> venueRequestList = new ArrayList<>();
        List<VenueRequestEntity> all = venueRequestRepository.findAll();

        all.forEach(venueRequestEntity -> venueRequestList.add(mapper.map(venueRequestEntity, VenueRequest.class)))
        ;
        return venueRequestList;
    }

    @Override
    public VenueRequest getById(Long id) {
        return mapper.map(venueRequestRepository.findById(id), VenueRequest.class);
    }

    @Override
    public boolean delete(Long id) {
        venueRequestRepository.deleteById(id);
        return true;
    }

    @Override
    public VenueRequest update(VenueRequest venueRequest) {
        return this.save(venueRequest);
    }
}

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
    private final ModelMapper modelMapper;

    @Override
    public VenueRequest save(VenueRequest venueRequest) {
        venueRequestRepository.save(modelMapper.map(venueRequest, VenueRequestEntity.class));
        return venueRequest;
    }

    @Override
    public List<VenueRequest> getAll() {
        List<VenueRequest> venueRequestList = new ArrayList<>();
        List<VenueRequestEntity> all = venueRequestRepository.findAll();

        all.forEach(venueRequestEntity -> {
            venueRequestList.add(modelMapper.map(venueRequestEntity, VenueRequest.class));
        });

        return venueRequestList;
    }

    @Override
    public VenueRequest getById(Long id) {
        return modelMapper.map(venueRequestRepository.findById(id), VenueRequest.class);
    }

    @Override
    public boolean delete(Long id) {
        venueRequestRepository.deleteById(id);
        return true;
    }

    @Override
    public VenueRequest update(VenueRequest venueRequest) {
        venueRequestRepository.save(modelMapper.map(venueRequest, VenueRequestEntity.class));
        return venueRequest;

    }
}

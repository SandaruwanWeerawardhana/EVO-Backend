package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Venue;
import edu.icet.entity.supplier.VenueEntity;
import edu.icet.repository.supplier.VenueRepository;
import edu.icet.service.supplier.VenueService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class VenueServiceImpl implements VenueService {
    private final VenueRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Venue> getAll() {
        List<VenueEntity> all = repository.findAll();

        List<Venue> venues = new ArrayList<>();

        all.forEach(venueEntity -> {
            venues.add(mapper.map(venueEntity,Venue.class));
        });
        return venues;
    }

    @Override
    public Venue save(Venue venue) {
        return mapper.map(repository.save(mapper.map(venue,VenueEntity.class)),Venue.class);
    }

    @Override
    public Boolean delete(Venue venue) {
        if (repository.existsById(venue.getVenueId())){
            repository.delete(mapper.map(venue,VenueEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Venue update(Venue venue) {
        return mapper.map(repository.save(mapper.map(venue,VenueEntity.class)),Venue.class);
    }

    @Override
    public Venue search(Long id){
        return mapper.map(repository.findById(id),Venue.class);
    }


}

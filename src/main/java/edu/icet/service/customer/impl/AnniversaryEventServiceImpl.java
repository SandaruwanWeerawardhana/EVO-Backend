package edu.icet.service.customer.impl;

import edu.icet.dto.Anniversary;
import edu.icet.entity.AnniversaryEntity;
import edu.icet.repository.AnniversaryEventRepository;
import edu.icet.service.customer.AnniversaryEventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnniversaryEventServiceImpl implements AnniversaryEventService {

    private final AnniversaryEventRepository repository;
    private final ModelMapper mapper;

    @Override
    public boolean add(Anniversary anniversary) {
        if (anniversary.getEventId() != null && repository.existsById(anniversary.getEventId())) {
            return false;
        }
        repository.save(mapper.map(anniversary, AnniversaryEntity.class));
        return true;
    }

    @Override
    public List<Anniversary> getAll() {
        return repository.findAll()
                .stream()
                .map(entity -> mapper.map(entity, Anniversary.class))
                .toList();
    }

    @Override
    public boolean delete(Long eventId) {
        if (eventId == null || !repository.existsById(eventId)) {
            return false;
        }
        repository.deleteById(eventId);
        return true;
    }

    @Override
    public boolean update(Anniversary anniversary) {
        if (anniversary == null || anniversary.getEventId() == null ||!repository.existsById(anniversary.getEventId())) {
            return false;
        }
        repository.save(mapper.map(anniversary, AnniversaryEntity.class));
        return true;
    }

    @Override
    public Anniversary get(Long eventId) {
        if (eventId <=0) {
            return null;
        }
        return repository.findById(eventId)
                .map(anniversaryEntity -> mapper.map(anniversaryEntity, Anniversary.class))
                .orElse(null);
    }
}

package edu.icet.service.event.impl;

import edu.icet.dto.event.Wedding;
import edu.icet.entity.event.WeddingEntity;
import edu.icet.repository.event.WeddingRepository;
import edu.icet.service.event.WeddingEventService;
import edu.icet.util.WeddingType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeddingEventServiceImpl implements WeddingEventService {

    private final WeddingRepository weddingRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Wedding> getAll() {
        return weddingRepository.findAll()
                .stream()
                .map(wedding -> modelMapper.map(wedding, Wedding.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Wedding wedding) {
        weddingRepository.save(modelMapper.map(wedding, WeddingEntity.class));
        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (weddingRepository.existsById(id)) {
            weddingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Wedding wedding) {
        return this.add(wedding);
    }

    @Override
    public Wedding get(Long id) {
        return weddingRepository.findById(id)
                .map(wedding -> modelMapper.map(wedding, Wedding.class))
                .orElse(null);
    }

    @Override
    public List<Wedding> getByDate(LocalDate date) {
        return weddingRepository.findByDate(date)
                .stream()
                .map(wedding -> modelMapper.map(wedding, Wedding.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Wedding> getByWeddingType(WeddingType weddingType) {
        return weddingRepository.findByWeddingType(weddingType)
                .stream()
                .map(wedding -> modelMapper.map(wedding, Wedding.class))
                .collect(Collectors.toList());
    }
}
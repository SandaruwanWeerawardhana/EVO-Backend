package edu.icet.service.supplier.impl;

import edu.icet.dto.Hall;
import edu.icet.dto.Profile;
import edu.icet.entity.HallEntity;
import edu.icet.repository.HallReopsitory;
import edu.icet.service.supplier.HallService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {
    final ModelMapper modelMapper;
    final HallReopsitory hallReopsitory;
  
    @Override
    public List<Hall> getAll(Profile profile) {
        return hallReopsitory.findAll()
                .stream()
                .map(hallEntity -> modelMapper.map(hallEntity, Hall.class))
                .toList();
    }

    @Override
    public Hall save(Hall hall) {
        HallEntity entity = modelMapper.map(hall, HallEntity.class);
        HallEntity savedEntity = hallReopsitory.save(entity);
        return modelMapper.map(savedEntity, Hall.class);
    }

    @Override
    public Hall search(Hall hall) {
        HallEntity entity = hallReopsitory.findById(hall.getHallId()).orElse(null);
        return entity != null ? modelMapper.map(entity, Hall.class) : null;
    }

    @Override
    public Boolean delete(Hall hall) {
        if (hallReopsitory.existsById(hall.getHallId())) {
            hallReopsitory.deleteById(hall.getHallId());
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        if (hallReopsitory.existsById(id)) {
            hallReopsitory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Hall update(Hall hall) {
        if (hallReopsitory.existsById(hall.getHallId())) {
            HallEntity entity = modelMapper.map(hall, HallEntity.class);
            HallEntity updatedEntity = hallReopsitory.save(entity);
            return modelMapper.map(updatedEntity, Hall.class);
        }
        return null;
    }
}
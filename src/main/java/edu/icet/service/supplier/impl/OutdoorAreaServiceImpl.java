package edu.icet.service.supplier.impl;

import edu.icet.dto.OutdoorArea;
import edu.icet.entity.OutdoorAreaEntity;
import edu.icet.repository.OutdoorAreaRepository;
import edu.icet.service.supplier.OutdoorAreaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OutdoorAreaServiceImpl implements OutdoorAreaService {
    final ModelMapper mapper;
    final OutdoorAreaRepository outdoorAreaRepository;

    @Override
    public List<OutdoorAreaEntity> getAll() {
        return outdoorAreaRepository.findAll();
    }

    @Override
    public OutdoorArea save(OutdoorArea outdoorArea) {
        OutdoorAreaEntity entity = mapper.map(outdoorArea, OutdoorAreaEntity.class);
        OutdoorAreaEntity savedEntity = outdoorAreaRepository.save(entity);
        return mapper.map(savedEntity, OutdoorArea.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (outdoorAreaRepository.existsById(id)) {
            outdoorAreaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(OutdoorArea outdoorArea) {
        if (outdoorAreaRepository.existsById(outdoorArea.getId())) {
            OutdoorAreaEntity entity = mapper.map(outdoorArea, OutdoorAreaEntity.class);
            outdoorAreaRepository.save(entity);
            return true;
        }
        return false;
    }
}
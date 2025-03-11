package edu.icet.service.impl;

import edu.icet.dto.OutdoorArea;
import edu.icet.service.OutdoorAreaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OutdoorAreaImpl implements OutdoorAreaService {

    final ModelMapper mapper;

    @Override
    public List<OutdoorArea> getAll() {
        return List.of();
    }

    @Override
    public OutdoorArea save(OutdoorArea outdoorArea) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(OutdoorArea outdoorArea) {
        return null;
    }
}

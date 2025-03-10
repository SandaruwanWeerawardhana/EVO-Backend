package edu.icet.service.supplier.impl;

import edu.icet.dto.OutdoorArea;
import edu.icet.service.supplier.OutdoorAreaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutdoorAreaServiceImpl implements OutdoorAreaService {
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

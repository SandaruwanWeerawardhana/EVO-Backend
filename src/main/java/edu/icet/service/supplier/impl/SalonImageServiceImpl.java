package edu.icet.service.supplier.impl;

import edu.icet.dto.SalonImage;
import edu.icet.service.supplier.SalonImageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalonImageServiceImpl implements SalonImageService {
    @Override
    public List<SalonImage> getAll() {
        return List.of();
    }

    @Override
    public SalonImage save(SalonImage salonImage) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public SalonImage update(SalonImage salonImage) {
        return null;
    }
}

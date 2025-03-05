package edu.icet.service.impl;

import edu.icet.dto.SalonImage;
import edu.icet.service.SalonImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SalonImageServiceImpl implements SalonImageService {

    final ModelMapper modelMapper;

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

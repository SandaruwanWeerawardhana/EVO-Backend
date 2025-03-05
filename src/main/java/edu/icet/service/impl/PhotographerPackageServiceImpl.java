package edu.icet.service.impl;

import edu.icet.dto.PhotographerImage;
import edu.icet.service.PhotographerImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotographerPackageServiceImpl implements PhotographerImageService {

    final ModelMapper modelMapper;

    @Override
    public List<PhotographerImage> getAll() {
        return List.of();
    }

    @Override
    public PhotographerImage save(PhotographerImage photographerImage) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public PhotographerImage update(PhotographerImage photographerImage) {
        return null;
    }
}

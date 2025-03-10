package edu.icet.service.supplier.impl;

import edu.icet.dto.PhotographerImage;
import edu.icet.service.supplier.PhotographerImageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotographerImageServiceImpl implements PhotographerImageService {
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

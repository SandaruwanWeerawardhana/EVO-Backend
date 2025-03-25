package edu.icet.service.supplier;

import edu.icet.dto.supplier.PhotographerImage;

import java.util.List;

public interface PhotographerImageService {
    List<PhotographerImage> getAll();
    PhotographerImage save(PhotographerImage photographerImage);
    Boolean delete(Long id);
    PhotographerImage update(PhotographerImage photographerImage);
}

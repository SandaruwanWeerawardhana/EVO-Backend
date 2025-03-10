package edu.icet.service.supplier;

import edu.icet.dto.PhotographerImage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhotographerImageService {
    List<PhotographerImage> getAll();
    PhotographerImage save(PhotographerImage photographerImage);
    Boolean delete(Long id);
    PhotographerImage update(PhotographerImage photographerImage);
}

package edu.icet.service;

import edu.icet.dto.PhotographerImage;

import java.util.List;

public interface PhotographerImageService {
    List<PhotographerImage> getAll();
    PhotographerImage save(PhotographerImage photographerImage);
    Boolean delete(Long id);
    PhotographerImage update(PhotographerImage photographerImage);
}

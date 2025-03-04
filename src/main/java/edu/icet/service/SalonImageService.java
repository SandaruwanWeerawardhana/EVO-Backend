package edu.icet.service;

import edu.icet.dto.SalonImage;

import java.util.List;

public interface SalonImageService {

    List<SalonImage> getAll();
    SalonImage save(SalonImage salonImage);
    Boolean delete(Long id);
    SalonImage update(SalonImage salonImage);

}

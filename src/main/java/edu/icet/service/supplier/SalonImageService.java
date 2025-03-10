package edu.icet.service.supplier;

import edu.icet.dto.SalonImage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SalonImageService {

    List<SalonImage> getAll();
    SalonImage save(SalonImage salonImage);
    Boolean delete(Long id);
    SalonImage update(SalonImage salonImage);

}

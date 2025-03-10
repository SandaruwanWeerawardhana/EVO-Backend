package edu.icet.service.supplier;

import edu.icet.dto.PhotographerPackage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhotographerPackageService {

    List<PhotographerPackage> getAll();
    PhotographerPackage save(PhotographerPackage photographerPackage);
    Boolean delete(Long id);
    PhotographerPackage update(PhotographerPackage photographerPackage);

}

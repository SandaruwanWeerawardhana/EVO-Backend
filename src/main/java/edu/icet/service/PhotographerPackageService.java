package edu.icet.service;

import edu.icet.dto.BeautyPackage;
import edu.icet.dto.PhotographerPackage;

import java.util.List;

public interface PhotographerPackageService {

    List<PhotographerPackage> getAll();
    PhotographerPackage save(PhotographerPackage photographerPackage);
    Boolean delete(Long id);
    PhotographerPackage update(PhotographerPackage photographerPackage);

}

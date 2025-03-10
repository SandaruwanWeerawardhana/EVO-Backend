package edu.icet.service.supplier.impl;

import edu.icet.dto.PhotographerPackage;
import edu.icet.service.supplier.PhotographerPackageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotographerPackageServiceImpl implements PhotographerPackageService {
    @Override
    public List<PhotographerPackage> getAll() {
        return List.of();
    }

    @Override
    public PhotographerPackage save(PhotographerPackage photographerPackage) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public PhotographerPackage update(PhotographerPackage photographerPackage) {
        return null;
    }
}

package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautyPackage;
import edu.icet.service.supplier.BeautyPackageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeautyPackageServiceImpl implements BeautyPackageService {
    @Override
    public List<BeautyPackage> getAll() {
        return List.of();
    }

    @Override
    public BeautyPackage save(BeautyPackage beautyPackage) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public BeautyPackage update(BeautyPackage beautyPackage) {
        return null;
    }
}

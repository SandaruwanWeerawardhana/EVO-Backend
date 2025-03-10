package edu.icet.service.supplier.impl;

import edu.icet.dto.MusicPackage;
import edu.icet.service.supplier.MusicPackageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicPackageServiceImpl implements MusicPackageService {
    @Override
    public Boolean create(MusicPackage musicPackage) {
        return null;
    }

    @Override
    public Boolean update(MusicPackage musicPackage) {
        return null;
    }

    @Override
    public List<MusicPackage> getAll() {
        return List.of();
    }

    @Override
    public MusicPackage getById(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}

package edu.icet.service.impl;

import edu.icet.dto.BeautyPackage;
import edu.icet.service.BeautyPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class BeautyPackageServiceImpl implements BeautyPackageService {


    final ModelMapper modelMapper;

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

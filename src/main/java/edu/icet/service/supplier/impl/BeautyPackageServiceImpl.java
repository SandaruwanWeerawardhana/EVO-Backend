package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.BeautyPackage;
import edu.icet.entity.event.BeautyPackageEntity;
import edu.icet.repository.supplier.BeautyPackageRepository;
import edu.icet.service.supplier.BeautyPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeautyPackageServiceImpl implements BeautyPackageService {
    final BeautyPackageRepository repository;
    final ModelMapper modelMapper;

    @Override
    public List<BeautyPackage> getAll() {
        List<BeautyPackage>beautyPackageList=new ArrayList<>();
        List<BeautyPackageEntity>all=repository.findAll();

        all.forEach(beautyPackageEntity -> {
            beautyPackageList.add(modelMapper.map(beautyPackageEntity, BeautyPackage.class));
        });
        return beautyPackageList;

    }

    @Override
    public BeautyPackage save(BeautyPackage beautyPackage) {
        repository.save(modelMapper.map(beautyPackage,BeautyPackageEntity.class));
        return beautyPackage;
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return !repository.existsById(id);
        }
        return false;
    }

    @Override
    public BeautyPackage update(BeautyPackage beautyPackage) {
        if(beautyPackage==null||beautyPackage.getId()==null) return null;
        BeautyPackageEntity savedEntity = repository.save(modelMapper.map(beautyPackage, BeautyPackageEntity.class));
        return modelMapper.map(savedEntity, BeautyPackage.class);
    }
}

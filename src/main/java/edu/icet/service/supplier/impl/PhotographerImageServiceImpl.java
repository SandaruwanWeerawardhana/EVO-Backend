package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautyPackage;
import edu.icet.dto.PhotographerImage;
import edu.icet.entity.BeautyPackageEntity;
import edu.icet.entity.PhotographerImageEntity;
import edu.icet.repository.PhotographerImageRepository;
import edu.icet.service.supplier.PhotographerImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PhotographerImageServiceImpl implements PhotographerImageService {
    final PhotographerImageRepository repository;
    final ModelMapper modelMapper;

    @Override
    public List<PhotographerImage> getAll() {

        List<PhotographerImage>photographerImageList=new ArrayList<>();
        List<PhotographerImageEntity>all=repository.findAll();

        all.forEach(beautyPackageEntity -> {
            photographerImageList.add(modelMapper.map(photographerImageList, PhotographerImage.class));
        });
        return photographerImageList;
    }

    @Override
    public PhotographerImage save(PhotographerImage photographerImage) {
        repository.save(modelMapper.map(photographerImage,PhotographerImageEntity.class));
        return photographerImage;
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public PhotographerImage update(PhotographerImage photographerImage) {
        if(photographerImage==null||photographerImage.getId()==null) return null;

        if (!repository.existsById(photographerImage.getId())) {
            return null;
        }

        PhotographerImageEntity savedEntity = repository.save(modelMapper.map(photographerImage, PhotographerImageEntity.class));

        return modelMapper.map(savedEntity, PhotographerImage.class);
    }
}

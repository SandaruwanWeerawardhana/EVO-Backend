package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.PropertyImage;
import edu.icet.entity.supplier.PropertyImageEntity;
import edu.icet.repository.supplier.PropertyImageRepository;
import edu.icet.service.supplier.PropertyImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PropertyImageServiceImpl implements PropertyImageService {
    final PropertyImageRepository repository;
    final ModelMapper mapper;

    @Override
    public List<PropertyImage> getAll() {
     List<PropertyImage>propertyImageList = new ArrayList<>();
     List<PropertyImageEntity> all = repository.findAll();

        all.forEach(propertyImageEntity -> {
            propertyImageList.add(mapper.map(propertyImageList,PropertyImage.class));
        });
        return propertyImageList;
    }
    @Override
    public PropertyImage save(PropertyImage propertyImage) {
        if(propertyImage==null){
            return null;
        }
        PropertyImageEntity save = repository.save(mapper.map(propertyImage,PropertyImageEntity.class));
        return mapper.map(save,PropertyImage.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(PropertyImage propertyImage) {
        if (repository.existsById(propertyImage.getId())){
            repository.save(mapper.map(propertyImage,PropertyImageEntity.class));
            return true;
        }
        return false;
    }
}

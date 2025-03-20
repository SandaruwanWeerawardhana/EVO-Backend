package edu.icet.service.supplier.impl;

import edu.icet.dto.PropertyImage;
import edu.icet.repository.PropertyImageRepository;
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
        return propertyImages;
    }
    @Override
    public PropertyImage save(PropertyImage propertyImage) {
        propertyImages.add(propertyImage);
        return propertyImage;
    }

    @Override
    public Boolean delete(Long id) {
        return propertyImages.removeIf(image -> image.getId().equals(id));
    }

    @Override
    public Boolean update(PropertyImage propertyImage) {
        for (PropertyImage image : propertyImages) {
            if (image.getId().equals(propertyImage.getId())) {
                int index = propertyImages.indexOf(image);
                propertyImages.set(index, propertyImage);
                return true;
            }
        }

        return false;
    }
}

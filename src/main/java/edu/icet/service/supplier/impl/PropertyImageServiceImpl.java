package edu.icet.service.supplier.impl;

import edu.icet.dto.PropertyImage;
import edu.icet.service.supplier.PropertyImageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyImageServiceImpl implements PropertyImageService {
    @Override
    public List<PropertyImage> getAll() {
        return List.of();
    }

    @Override
    public PropertyImage save(PropertyImage propertyImage) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(PropertyImage propertyImage) {
        return null;
    }
}

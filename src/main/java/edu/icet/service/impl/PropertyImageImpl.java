package edu.icet.service.impl;

import edu.icet.dto.PropertyImage;
import edu.icet.service.PropertyImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PropertyImageImpl implements PropertyImageService {
    final ModelMapper mapper;
    @Override
    public List<PropertyImage> getAll() {
        return List.of();
    }

    @Override
    public PropertyImage save(PropertyImage propertyImage) {
        System.out.println("asdad");
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

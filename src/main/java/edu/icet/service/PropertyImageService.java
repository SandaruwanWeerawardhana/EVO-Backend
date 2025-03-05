package edu.icet.service;

import edu.icet.dto.PropertyImage;

import java.util.List;

public interface PropertyImageService {
    List<PropertyImage> getAll();
    PropertyImage save (PropertyImage propertyImage);
    Boolean delete(Long id);
    Boolean update(PropertyImage propertyImage);
}

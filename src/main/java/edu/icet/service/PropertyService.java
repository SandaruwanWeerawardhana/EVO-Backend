package edu.icet.service;

import edu.icet.dto.Property;
import edu.icet.dto.Room;

import java.util.List;

public interface PropertyService {
    List<Property> getAll();
    Property save(Property property);
    Boolean delete(Property property);
    Boolean delete(Long id);
    Property update(Property property);
}

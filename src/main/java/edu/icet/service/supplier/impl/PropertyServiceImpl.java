package edu.icet.service.supplier.impl;

import edu.icet.dto.Property;
import edu.icet.service.supplier.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements PropertyService {
    @Override
    public List<Property> getAll() {
        return List.of();
    }

    @Override
    public Property save(Property property) {
        return null;
    }

    @Override
    public Property search(String query) {
        return null;
    }

    @Override
    public Boolean delete(Property property) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Property update(Property property) {
        return null;
    }
}

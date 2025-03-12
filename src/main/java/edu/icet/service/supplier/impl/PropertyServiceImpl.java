package edu.icet.service.supplier.impl;

import edu.icet.dto.Property;
import edu.icet.service.supplier.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final List<Property> propertyList = new ArrayList<>();

    @Override
    public List<Property> getAll() {
        return propertyList;
    }

    @Override
    public Property save(Property property) {
        propertyList.add(property);
        return property;
    }

    @Override
    public Property search(Property property) {
        for (Property propertyTest : propertyList){
            if (propertyTest.getPropertyId().equals(property.getPropertyId())){
                return propertyTest;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Property property) {
        return propertyList.removeIf(propertyCheck -> propertyCheck.getPropertyId().equals(property.getPropertyId()));
    }

    @Override
    public Boolean delete(Long id) {
        return propertyList.removeIf(property -> property.getPropertyId().equals(id));
    }

    @Override
    public Property update(Property property) {
        for (int a=0; a<propertyList.size(); a++){
            if (propertyList.get(a).getPropertyId().equals(property.getPropertyId())){
                property.setPropertyId(property.getPropertyId());
                propertyList.set(a,property);
                return property;
            }
        }
        return null;
    }
}

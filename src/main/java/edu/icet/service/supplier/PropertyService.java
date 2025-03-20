package edu.icet.service.supplier;

import edu.icet.dto.Property;
import edu.icet.repository.BookingSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PropertyService {
    ;

    List<Property> getAll();
    Property save(Property property);
    Property search(Property property);
    Boolean delete(Property property);
    Boolean delete(Long id);
    Property update(Property property);
}

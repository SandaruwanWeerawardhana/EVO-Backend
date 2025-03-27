package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Property;
import edu.icet.service.supplier.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/supplier/property")
@RestController

public class PropertyController {
    final PropertyService propertyService;

    @PostMapping("/save")
    public void saveProperty(@RequestBody Property property){
        propertyService.save(property);
    }

    @GetMapping("/get-all")
    public List<Property> getAll(){
        return propertyService.getAll();
    }

    @GetMapping("/search")
    public Property searchProperty(@RequestBody Property property){
        return propertyService.search(property);
    }

    @PutMapping("/update")
    public Property updateProperty(@RequestBody Property property){
        return propertyService.update(property);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteById(@RequestParam Long id){
        return propertyService.delete(id);
    }
}

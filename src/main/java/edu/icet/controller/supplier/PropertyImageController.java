package edu.icet.controller.supplier;

import edu.icet.dto.supplier.PropertyImage;
import edu.icet.service.supplier.PropertyImageService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Hidden
@RestController
@RequestMapping("/supplier/venue/property/image")
@RequiredArgsConstructor
@CrossOrigin

public class PropertyImageController {

    final PropertyImageService propertyImageService;

    @PostMapping("/add")
    public PropertyImage add(@RequestBody PropertyImage propertyImage) {
        return propertyImageService.save(propertyImage);

    }
    @GetMapping("/getAll")
    public List<PropertyImage> getAll() {
        return propertyImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean Delete(@PathVariable Long id) {
        return propertyImageService.delete(id);

    }

    @PutMapping("/update-propertyImage")
    public boolean updateCustomer(@RequestBody PropertyImage propertyImage){
       return propertyImageService.update(propertyImage);

    }


}

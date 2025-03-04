package edu.icet.controller;

import edu.icet.dto.PropertyImage;
import edu.icet.service.PropertyImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/venue/property/image")
@RequiredArgsConstructor
@CrossOrigin

public class PropertyImageController {

    final PropertyImageService propertyImageService;

    @PostMapping("/add")
    public void add(@RequestBody PropertyImage propertyImage) {
        propertyImageService.save(propertyImage);

    }
    @GetMapping("/getAll")
    public List<PropertyImage> getAll() {
        return propertyImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable Long id) {
        propertyImageService.delete(id);

    }

    @PutMapping("/update-propertyImage")
    public void updateCustomer(@RequestBody PropertyImage propertyImage){
        propertyImageService.update(propertyImage);

    }


}

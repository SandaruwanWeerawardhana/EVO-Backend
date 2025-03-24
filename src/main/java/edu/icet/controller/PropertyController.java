package edu.icet.controller;

import edu.icet.dto.Property;
import edu.icet.service.supplier.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/supplier/property")
@RestController

public class PropertyController {
    final PropertyService service;

    @PostMapping("/save")
    public void saveProperty(@RequestBody Property property){
        service.save(property);
    }

    @GetMapping("/get-all")
    public List<Property> getAll(){
        return service.getAll();
    }

    @GetMapping("/search")
    public Property searchProperty(@RequestBody Property property){
        return service.search(property);
    }

    @PutMapping("/update")
    public Property updateProperty(@RequestBody Property property){
        return service.update(property);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteById(@RequestParam Long id){
        return service.delete(id);
    }
}

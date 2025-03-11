package edu.icet.controller;


import edu.icet.dto.SalonImage;
import edu.icet.service.supplier.SalonImageService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Hidden
@RestController
@RequestMapping("/supplier/salon/image")
@RequiredArgsConstructor
@CrossOrigin
public class SalonImageController {

    final SalonImageService salonImageService;


    @PostMapping("/add")
    public SalonImage addSalonImage(@RequestBody SalonImage salonImage){
       return salonImageService.save(salonImage);
    }

    @GetMapping("/getAll")
    public List<SalonImage> getAll(){
        return salonImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteSalonImage(@PathVariable("id") Long id){
        return  salonImageService.delete(id);
    }

    @PutMapping("/update")
    public SalonImage updateSalonImage(@RequestBody SalonImage salonImage){
        return  salonImageService.update(salonImage);
    }

}

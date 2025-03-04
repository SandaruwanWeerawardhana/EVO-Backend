package edu.icet.controller;


import edu.icet.dto.BeautyPackage;
import edu.icet.dto.SalonImage;
import edu.icet.service.SalonImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/salon/image")
@RequiredArgsConstructor
@CrossOrigin
public class SalonImageController {

    final SalonImageService salonImageService;


    @PostMapping("/add")
    public void addSalonImage(@RequestBody SalonImage salonImage){
        salonImageService.save(salonImage);
    }

    @GetMapping("/getAll")
    public List<SalonImage> getAll(){
        return salonImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalonImage(@PathVariable("id") Long id){
        salonImageService.delete(id);
    }

    @PutMapping("/update")
    public void updateSalonImage(@RequestBody SalonImage salonImage){
        salonImageService.update(salonImage);
    }

}

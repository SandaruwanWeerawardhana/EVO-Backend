package edu.icet.controller;

import edu.icet.dto.PhotographerPackage;
import edu.icet.service.PhotographerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/photographer/package")
@RequiredArgsConstructor
@CrossOrigin
public class PhtographerPackageController {

    final PhotographerPackageService photographerPackageService;


    @PostMapping("/add")
    public void addPhotographerPackage(@RequestBody PhotographerPackage photographerPackage){
        photographerPackageService.save(photographerPackage);
    }

    @GetMapping("/getAll")
    public List<PhotographerPackage> getAll(){
        return photographerPackageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhotographerPackage(@PathVariable("id") Long id){
        photographerPackageService.delete(id);
    }

    @PutMapping("/update")
    public void updatePhotographerPackage(@RequestBody PhotographerPackage photographerPackage){

        photographerPackageService.update(photographerPackage);
    }


}

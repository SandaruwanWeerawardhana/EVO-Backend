package edu.icet.controller;

import edu.icet.dto.PhotographerPackage;
import edu.icet.service.supplier.PhotographerPackageService;
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
    public PhotographerPackage addPhotographerPackage(@RequestBody PhotographerPackage photographerPackage){
       return photographerPackageService.save(photographerPackage);
    }

    @GetMapping("/getAll")
    public List<PhotographerPackage> getAll(){
        return photographerPackageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePhotographerPackage(@PathVariable("id") Long id){
        return  photographerPackageService.delete(id);
    }

    @PutMapping("/update")
    public PhotographerPackage updatePhotographerPackage(@RequestBody PhotographerPackage photographerPackage){

        return photographerPackageService.update(photographerPackage);
    }


}

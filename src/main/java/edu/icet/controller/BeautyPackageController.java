package edu.icet.controller;


import edu.icet.dto.BeautyPackage;
import edu.icet.dto.PhotographerPackage;
import edu.icet.service.BeautyPackageService;
import edu.icet.service.PhotographerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/beauty/package")
@RequiredArgsConstructor
@CrossOrigin
public class BeautyPackageController {

    final BeautyPackageService beautyPackageService;

    @PostMapping("/add")
    public void addBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        beautyPackageService.save(beautyPackage);
    }

    @GetMapping("/getAll")
    public List<BeautyPackage> getAll(){
        return beautyPackageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBeautyPackage(@PathVariable("id") Long id){
        beautyPackageService.delete(id);
    }

    @PutMapping("/update")
    public void updateBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        beautyPackageService.update(beautyPackage);
    }
}

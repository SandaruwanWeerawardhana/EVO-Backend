package edu.icet.controller;


import edu.icet.dto.BeautyPackage;
import edu.icet.service.supplier.BeautyPackageService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Hidden
@RestController
@RequestMapping("/supplier/beauty/package")
@RequiredArgsConstructor
@CrossOrigin
public class BeautyPackageController {

    final BeautyPackageService beautyPackageService;

    @PostMapping("/add")
    public BeautyPackage addBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        return beautyPackageService.save(beautyPackage);
    }

    @GetMapping("/getAll")
    public List<BeautyPackage> getAll(){
        return beautyPackageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBeautyPackage(@PathVariable("id") Long id){
        return beautyPackageService.delete(id);
    }

    @PutMapping("/update")
    public BeautyPackage updateBeautyPackage(@RequestBody BeautyPackage beautyPackage){
        return beautyPackageService.update(beautyPackage);
    }
}

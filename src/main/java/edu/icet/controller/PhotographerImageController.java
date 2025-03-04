package edu.icet.controller;

import edu.icet.dto.BeautyPackage;
import edu.icet.dto.PhotographerImage;
import edu.icet.dto.PhotographerPackage;
import edu.icet.service.BeautyPackageService;
import edu.icet.service.PhotographerImageService;
import edu.icet.service.PhotographerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/photographer/image")
@RequiredArgsConstructor
@CrossOrigin
public class PhotographerImageController {

    final PhotographerImageService photographerImageService;

    @PostMapping("/add")
    public void addPhotographerImage(@RequestBody PhotographerImage photographerImage){
        photographerImageService.save(photographerImage);
    }

    @GetMapping("/getAll")
    public List<PhotographerImage> getAll(){
        return photographerImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhotographerImage(@PathVariable("id") Long id){
        photographerImageService.delete(id);
    }

    @PutMapping("/update")
    public void updatePhotographerImage(@RequestBody PhotographerImage photographerImage){
        photographerImageService.update(photographerImage);
    }

}

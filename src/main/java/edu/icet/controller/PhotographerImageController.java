package edu.icet.controller;

import edu.icet.dto.PhotographerImage;
import edu.icet.service.supplier.PhotographerImageService;
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
    public PhotographerImage addPhotographerImage(@RequestBody PhotographerImage photographerImage){
       return photographerImageService.save(photographerImage);
    }

    @GetMapping("/getAll")
    public List<PhotographerImage> getAll(){
        return photographerImageService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletePhotographerImage(@PathVariable("id") Long id){
        return  photographerImageService.delete(id);
    }

    @PutMapping("/update")
    public PhotographerImage updatePhotographerImage(@RequestBody PhotographerImage photographerImage){
       return photographerImageService.update(photographerImage);
    }

}

package edu.icet.controller.supplier;

import edu.icet.dto.supplier.PhotographerImage;
import edu.icet.service.supplier.PhotographerImageService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Hidden
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

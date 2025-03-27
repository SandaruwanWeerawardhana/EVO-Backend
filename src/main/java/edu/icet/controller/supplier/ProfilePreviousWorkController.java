package edu.icet.controller.supplier;

import edu.icet.dto.supplier.ProfilePreviousWork;
import edu.icet.dto.supplier.Supplier;
import edu.icet.service.supplier.ProfilePreviousWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier/previous-work")
@CrossOrigin
@RequiredArgsConstructor

public class ProfilePreviousWorkController {

    final ProfilePreviousWorkService service;

    @PostMapping("/save")
    public void saveWork(@RequestBody ProfilePreviousWork previousWork){
        service.save(previousWork);
    }

    @GetMapping("/get-all")
    public List<ProfilePreviousWork> getAll(){
        return service.getAll();
    }

    @PutMapping("/update")
    public boolean updateProfile(@RequestBody ProfilePreviousWork previousWork){
        return service.update(previousWork);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteProfileById(@RequestParam Long id){
        return service.delete(id);
    }

    @GetMapping("/get-previous-work-by-id")
    public ProfilePreviousWork searchPreviousWork(@RequestParam ProfilePreviousWork profilePreviousWork){
        return service.search(profilePreviousWork);
    }
}

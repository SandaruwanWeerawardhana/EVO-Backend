package edu.icet.controller;

import edu.icet.dto.Profile;
import edu.icet.dto.ProfilePreviousWork;
import edu.icet.service.ProfilePreviousWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
@RequiredArgsConstructor

public class ProfilePreviousWorkController {

    final ProfilePreviousWorkService service;

    @PostMapping("/save-previousWork")
    public void saveWork(@RequestBody ProfilePreviousWork previousWork){
        service.save(previousWork);
    }

    @GetMapping("/getAll")
    public List<ProfilePreviousWork> getAll(@RequestBody Profile profile){
        return service.getAll(profile);
    }

    @PutMapping("/update")
    public ProfilePreviousWork updateProfile(@RequestBody ProfilePreviousWork previousWork){
        return service.update(previousWork);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteProfileById(@PathVariable Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteProfile(@RequestBody ProfilePreviousWork previousWork){
        return service.delete(previousWork);
    }
}

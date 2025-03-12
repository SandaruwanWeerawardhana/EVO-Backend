package edu.icet.controller;

import edu.icet.dto.ProfilePreviousWorkImage;
import edu.icet.service.system.ProfilePreviousWorkImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/previous-work-img")
@CrossOrigin
@RequiredArgsConstructor
public class ProfilePreviousWorkImageController {

    private final ProfilePreviousWorkImageService profilePreviousWorkImageService;

    @PostMapping("/add-work-img")
    public ProfilePreviousWorkImage addPreviousWorkImage(@RequestBody ProfilePreviousWorkImage profilePreviousWorkImage) {
        return profilePreviousWorkImageService.addPreviousWorkImage(profilePreviousWorkImage);
    }

    @PutMapping("/update-work-img")
    public ProfilePreviousWorkImage updatePreviousWorkImage(@RequestBody ProfilePreviousWorkImage profilePreviousWorkImage) {
        return profilePreviousWorkImageService.updatePreviousWorkImage(profilePreviousWorkImage);
    }

    @GetMapping("/all-work-img")
    public List<ProfilePreviousWorkImage> getAllPreviousWorkImages() {
        return profilePreviousWorkImageService.getAllPreviousWorkImage();
    }

    @DeleteMapping("/delete-work-img/{id}")
    public void deletePreviousWorkImage(@PathVariable Long id) {
        profilePreviousWorkImageService.deleteByProfilePreviousWorkImageId(id);
    }

    @GetMapping("/search-work-img/{id}")
    public ProfilePreviousWorkImage searchPreviousWorkImage(@PathVariable Long id) {
        return profilePreviousWorkImageService.searchByProfilePreviousWorkImageId(id);
    }
}

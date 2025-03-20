package edu.icet.controller;

import edu.icet.dto.Profile;
import edu.icet.service.system.ProfileService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Hidden
@RestController
@RequestMapping("/supplier/profiles")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {
    final ProfileService profileService;

    @PostMapping("add")
    public ResponseEntity<Profile> addProfile(@Valid @RequestBody Profile profile) {
        Profile createdProfile = profileService.addProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @PutMapping("/update")
    public ResponseEntity<Profile> updateProfile(@Valid @RequestBody Profile profile) {
        Profile updatedProfile = profileService.updateProfile(profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok("Profile deleted successfully.");
    }


}

package edu.icet.controller;

import edu.icet.dto.ProfileImage;
import edu.icet.service.ProfileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/profile-images")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileImageController {
    final ProfileImageService profileImageService;

    @PostMapping("/update/{userId}")
    public ResponseEntity<String> updateProfileImage(@PathVariable Long userId,
                                                     @RequestParam("file") MultipartFile file) {
        try {
            ProfileImage profileImage = new ProfileImage();
            profileImage.setUserId(userId);
            profileImage.setProfileImage(file);

            profileImageService.updateProfileImage(profileImage);
            return ResponseEntity.ok("Profile image updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating profile image.");
        }
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable Integer userId) {
        Optional<ProfileImage> profileImageOpt = profileImageService.getProfileImageByUserId(userId);

        if (profileImageOpt.isPresent()) {
            try {
                ProfileImage profileImage = profileImageOpt.get();
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)  // Adjust based on file type
                        .body(profileImage.getProfileImage().getBytes());
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteProfileImage(@PathVariable Integer userId) {
        profileImageService.deleteProfileImage(userId);
        return ResponseEntity.ok("Profile image deleted successfully.");
    }
}

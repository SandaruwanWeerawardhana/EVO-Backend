package edu.icet.controller.supplier;

import edu.icet.dto.supplier.ProfileExtraFeature;
import edu.icet.service.supplier.ProfileExtraFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/venue/profile-extra-feature")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileExtraFeatureController {

    final ProfileExtraFeatureService profileExtraFeatureService;

    @PostMapping("/add")
    public Boolean save(@RequestBody ProfileExtraFeature profileExtraFeature) {
        return profileExtraFeatureService.save(profileExtraFeature);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return profileExtraFeatureService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Long id, ProfileExtraFeature profileExtraFeature) {
        return profileExtraFeatureService.update(id, profileExtraFeature);
    }

    @GetMapping("/getAll")
    public List<ProfileExtraFeature> getAll() {
        return profileExtraFeatureService.getAll();
    }

    @GetMapping("/get/{id}")
    public ProfileExtraFeature searchById(@PathVariable Long id) {
        return profileExtraFeatureService.searchById(id);
    }
}

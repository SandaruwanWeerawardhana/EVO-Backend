package edu.icet.controller;


import edu.icet.dto.MusicPackage;
import edu.icet.service.MusicPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/music/package")
@RequiredArgsConstructor
public class MusicPackageController {

    private final MusicPackageService musicPackageService;

    @PostMapping("/create")
    public boolean create(@RequestBody MusicPackage musicPackage) {
        return musicPackageService.create(musicPackage);
    }

    @GetMapping("/get-all")
    public List<MusicPackage> getAll() {
        return musicPackageService.getAll();
    }

    @PostMapping("/update")
    public boolean update(@RequestBody MusicPackage musicPackage) {
        return musicPackageService.update(musicPackage);
    }


    @GetMapping("/get-by-id")
    public MusicPackage getById(@RequestParam(value = "id") Integer id) {
        return musicPackageService.getById(id);
    }

    @DeleteMapping("/delete")
    public MusicPackage delete(@RequestParam(value = "id") Integer id) {
        return musicPackageService.getById(id);
    }

}

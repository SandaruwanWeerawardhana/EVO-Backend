package edu.icet.controller;

import edu.icet.dto.Hall;
import edu.icet.dto.Profile;
import edu.icet.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/supplier/Hall")
@CrossOrigin
@RequiredArgsConstructor
@RestController

public class HallController {

    final HallService service;

    @PostMapping("/save")
    public void saveData(@RequestBody Hall hall){
        service.save(hall);
    }

    @GetMapping("/get-all")
    public List<Hall> getData(@RequestBody Profile profile){
        return service.getAll(profile);
    }

    @PutMapping("/update")
    public Hall updateHallData(@RequestBody Hall hall){
        return service.update(hall);
    }

    @GetMapping("/search-hall-by-id")
    public Hall searchHall(@RequestParam String query){
        return service.search(query);
    }

    @DeleteMapping("/delete-by-id")
    public boolean deleteHallById(@RequestParam Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteHall(@RequestBody Hall hall){
        return service.delete(hall);
    }
}

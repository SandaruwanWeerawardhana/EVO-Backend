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
    public void saveData(Hall hall){
        service.save(hall);
    }

    @GetMapping("/getAll")
    public List<Hall> getData(Profile profile){
        return service.getAll(profile);
    }

    @PutMapping("/update")
    public Hall updateHallData(Hall hall){
        return service.update(hall);
    }

    @GetMapping("/searchHallById")
    public Hall searchHall(String query){
        return service.search(query);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteHallById(Long id){
        return service.delete(id);
    }

    @DeleteMapping("/delete")
    public boolean deleteHall(Hall hall){
        return service.delete(hall);
    }
}

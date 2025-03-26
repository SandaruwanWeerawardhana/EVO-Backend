package edu.icet.controller.supplier;

import edu.icet.dto.supplier.Hall;
import edu.icet.service.supplier.HallService;
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
    public List<Hall> getData(){
        return service.getAll();
    }

    @PutMapping("/update")
    public Hall updateHallData(@RequestBody Hall hall){
        return service.update(hall);
    }

    @GetMapping("/search-hall-by-id")
    public Hall searchHall(@RequestBody Hall hall){
        return service.search(hall);
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

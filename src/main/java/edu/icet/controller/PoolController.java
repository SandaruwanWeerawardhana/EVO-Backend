package edu.icet.controller;


import edu.icet.dto.Pool;
import edu.icet.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/venue/pool")
@RequiredArgsConstructor
@CrossOrigin

public class PoolController {

    final PoolService poolService;

    @PostMapping("/add")
    public void save(@RequestBody Pool pool){
       poolService.save(pool);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        poolService.delete(id);
    }

    @PutMapping("/update-pool")
    public void update(@RequestBody Pool pool){
        poolService.update(pool);
    }

    @GetMapping("/getAll")
    public List <Pool> getAll() {
        return poolService.getAll();
    }


}

package edu.icet.controller;


import edu.icet.dto.Pool;
import edu.icet.service.supplier.PoolService;
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
    public Pool save(@RequestBody Pool pool){
       return poolService.save(pool);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
       return poolService.delete(id);
    }

    @PutMapping("/update-pool")
    public boolean update(@RequestBody Pool pool){
        return poolService.update(pool);
    }

    @GetMapping("/getAll")
    public List <Pool> getAll() {
        return poolService.getAll();
    }


}

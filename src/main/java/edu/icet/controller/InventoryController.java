package edu.icet.controller;

import edu.icet.dto.Inventory;
import edu.icet.service.supplier.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/supplier/Inventory")
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class InventoryController {
    final InventoryService service;

    @PostMapping("/add")
    public boolean add(@RequestBody Inventory inventory){
        return service.add(inventory);
    }

    @GetMapping("/get-all")
    public List<Inventory> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{name}")
    public List<Inventory> searchByName(@PathVariable("name") String name){
        return service.search(name);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return service.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Inventory inventory){
        return service.update(inventory);
    }

}

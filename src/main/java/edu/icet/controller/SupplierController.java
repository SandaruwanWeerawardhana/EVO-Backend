package edu.icet.controller;

import edu.icet.dto.Supplier;

import edu.icet.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor

public class SupplierController {

    final SupplierService supplierService;

    @PostMapping("/add")
    public void add(@RequestBody Supplier supplier){
        supplierService.add(supplier);
    }

    @GetMapping("/all")
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/search/{category}")
    public List<Supplier> getByCategory(@PathVariable String category){ return supplierService.getByCategory(category); }

    @GetMapping("/search")
    public void search(@RequestBody Supplier query){ supplierService.search(query); }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        supplierService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Supplier supplier){
        supplierService.update(supplier);
    }
}

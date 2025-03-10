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
    public void addSupplier(@RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
    }

    @GetMapping("/all")
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }

    @GetMapping("/search/{id}")
    public void searchByID(@PathVariable String id){
        supplierService.searchSupplier(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        supplierService.deleteSupplier(id);
    }

    @PutMapping("update")
    public void update(@RequestBody Supplier supplier){
        supplierService.updateSupplier(supplier);
    }
}

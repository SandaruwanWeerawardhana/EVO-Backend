package edu.icet.controller;

import edu.icet.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SupplierController {

    @PostMapping("/add")
    public void addSupplier(@RequestBody Supplier supplier){

        SupplierService.addSupplier(supplier);
    }

    @GetMapping("/getAll")
    public List<Supplier> getAll(){
        return SupplierService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id){
        SupplierService.deleteSupplier(id);
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Supplier supplier){

        SupplierService.updateSupplier(supplier);
    }


}

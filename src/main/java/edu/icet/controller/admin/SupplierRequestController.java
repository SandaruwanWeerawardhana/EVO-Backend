package edu.icet.controller.admin;


import edu.icet.dto.supplier.SupplierRequest;
import edu.icet.service.supplier.SupplierRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/supplier/request")
@RequiredArgsConstructor

public class SupplierRequestController {

    private final SupplierRequestService service;

    @PostMapping("/save")
    public void saveSupplierRequest(@RequestBody SupplierRequest supplierRequest){
        service.addSupplierRequest(supplierRequest);
    }

    @GetMapping("/get-all")
    public List<SupplierRequest> getAll(){
        return service.getAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody SupplierRequest supplierRequest){
        service.update(supplierRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

    @GetMapping("/search")
    public SupplierRequest searchById(@RequestParam Long id){
        return service.findById(id);
    }
}

package edu.icet.controller;

import edu.icet.dto.PackageFeatureDetail;
import edu.icet.service.supplier.PackageFeatureDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/package/packageFeatureDetail")
@RequiredArgsConstructor
@CrossOrigin
public class PackageFeatureDetailController {
    final PackageFeatureDetailService service;

    @GetMapping("/all")
    public List<PackageFeatureDetail> getAll(){return service.getAll();}

    @PostMapping("/add")
    public void add(@RequestBody PackageFeatureDetail detail){service.add(detail);}

    @GetMapping("/search")
    public PackageFeatureDetail search(@RequestBody PackageFeatureDetail query){return service.search(query);}

    @PutMapping("/update")
    public void update(@RequestBody PackageFeatureDetail detail){service.update(detail);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){service.delete(id);}
}

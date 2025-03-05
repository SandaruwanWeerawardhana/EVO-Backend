package edu.icet.controller;


import edu.icet.dto.BeautySaloon;
import edu.icet.dto.BirthdayParty;
import edu.icet.service.BeautySaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/beauty-salon")
@RequiredArgsConstructor
@CrossOrigin
public class BeautySalonController {

    final BeautySaloonService service;

    @PostMapping("/add")
    public void add(@RequestBody BeautySaloon beautySaloon){
        service.add(beautySalonController);
    }

    @GetMapping("/get-all")
    public List<BeautySalonController> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        service.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody BeautySaloon beautySaloon){
        service.update(beautySalonController);
    }

    @GetMapping("/get-id/{id}")
    public BeautySaloon getId(@PathVariable String id){
        service.get(id);
    }

    @GetMapping("/get-all-by-name/{name}")
    public BeautySaloon getAllByName(@PathVariable String name){
        service.getByName(name);
    }
}

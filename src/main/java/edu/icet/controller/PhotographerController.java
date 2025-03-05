package edu.icet.controller;

import edu.icet.dto.Photographer;
import edu.icet.service.PhotographerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier/photographer")
@CrossOrigin
public class PhotographerController {

    final PhotographerService service;

    @GetMapping("/all")
    public List<Photographer> getAll(){return service.getAll();}

    @PostMapping("/add")
    public void add(@RequestBody Photographer photographer){service.save(photographer);}

    @GetMapping("/search/{query}")
    public Photographer search(@RequestBody Photographer query){return service.search(query);}

    @PutMapping("/update")
    public void update(@RequestBody Photographer photographer){service.update(photographer);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){service.delete(id);}
}

package edu.icet.controller;

import edu.icet.dto.GetTogether;
import edu.icet.service.GetTogetherEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/get-together")
public class GetTogetherEventController {

    final GetTogetherEventService service;

    @PostMapping("/add")
    public void addGetTogether(@RequestBody GetTogether getTogether){
        service.addGetTogether(getTogether);
    }

    @GetMapping("/get-all")
    public List<GetTogether> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{id}")
    public GetTogether searchById(@PathVariable Integer id){
        return service.searchById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGetTogether(@PathVariable Integer id){
        service.deleteGetTogether(id);
    }

    @PutMapping("/update")
    public void updateGetTogether(@RequestBody GetTogether  getTogether){
        service.updateGetTogether(getTogether);
    }
}

package edu.icet.controller;

import edu.icet.dto.GetTogether;
import edu.icet.service.event.GetTogetherEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/get-together")
public class GetTogetherEventController {

    private final GetTogetherEventService service;

    @PostMapping("/add")
    public boolean add(@RequestBody GetTogether getTogether){

        return service.add(getTogether);
    }

    @GetMapping("/get-all")
    public List<GetTogether> getAll(){
        return service.getAll();
    }

    @GetMapping("/search/{id}")
    public GetTogether get(@PathVariable("id") Integer id){
        return service.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){

        return service.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody GetTogether  getTogether){

        return service.update(getTogether);
    }
}

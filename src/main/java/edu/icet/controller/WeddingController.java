package edu.icet.controller;

import edu.icet.dto.Wedding;
import edu.icet.service.event.WeddingEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/wedding")
@RequiredArgsConstructor
@CrossOrigin
public class WeddingController {
    private final WeddingEventService weddingEventService;

    @GetMapping("/get/{id}")
    public Wedding get(@PathVariable("id") Long id){
        return weddingEventService.get(id);
    }

    @GetMapping("/get-by-date/{date}")
    public List<Wedding> get(@PathVariable("date") LocalDate date){
        return weddingEventService.getByDate(date);
    }

    @GetMapping("/get-all")
    public List<Wedding> getAll(){
        return weddingEventService.getAll();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Wedding wedding){
        return weddingEventService.add(wedding);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return weddingEventService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Wedding wedding){
        return weddingEventService.update(wedding);
    }
}

package edu.icet.controller;

import edu.icet.dto.Wedding;
import edu.icet.service.WeddingEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/wedding")
@RequiredArgsConstructor
public class WeddingController {
    private final WeddingEventService weddingEventService;

    @GetMapping("/get/{id}")
    public Wedding get(@PathVariable String id){
        return weddingEventService.get(id);
    }

    @GetMapping("/get-by-date/{date}")
    public List<Wedding> get(@PathVariable LocalDate date){
        return weddingEventService.getByDate(date);
    }

    @GetMapping("/get-all")
    public List<Wedding> getAll(){
        return weddingEventService.getAll();
    }

    @RequestMapping("/save")
    public boolean save(@RequestBody Wedding wedding){
        return weddingEventService.add(wedding);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return weddingEventService.delete(id);
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody Wedding wedding){
        return weddingEventService.update(wedding);
    }
}

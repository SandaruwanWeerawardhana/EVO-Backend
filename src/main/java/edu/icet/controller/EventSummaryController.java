package edu.icet.controller;

import edu.icet.dto.EventSummary;
import edu.icet.service.system.EventSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventsummary")
@RequiredArgsConstructor
@CrossOrigin
public class EventSummaryController {

    private final EventSummaryService eventSummaryService;

    @PostMapping("/add")
    public boolean add(@RequestBody EventSummary eventSummary){
        return eventSummaryService.add(eventSummary);
    }

    @GetMapping("/get-all")
    public List<EventSummary> getall(){
        return eventSummaryService.getall();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return eventSummaryService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody EventSummary eventSummary){
        return eventSummaryService.update(eventSummary);
    }

    @GetMapping("/get/{id}")
    public EventSummary getById(@PathVariable("id") Integer id){
        return eventSummaryService.getById(id);
    }
}

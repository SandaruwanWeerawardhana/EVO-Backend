package edu.icet.controller;

import edu.icet.dto.Agenda;
import edu.icet.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
@CrossOrigin
public class AgendaController {
    AgendaService agendaService;

    @PostMapping("/create")
    public boolean create(@RequestBody Agenda agenda){
        return agendaService.create(agenda);
    }

    @GetMapping("/get-all")
    public List<Agenda> getAll(){
        return agendaService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return agendaService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Agenda agenda){
        return agendaService.update(agenda);
    }

    @GetMapping("/get/{id}")
    public Agenda getById(@PathVariable("id")Integer id){
        return agendaService.getById(id);
    }
}

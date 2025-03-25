package edu.icet.controller;

import edu.icet.dto.Agenda;
import edu.icet.dto.AgendaTask;
import edu.icet.service.customer.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
@RequiredArgsConstructor
@CrossOrigin
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping("/add")
    public boolean create(@RequestBody Agenda agenda){
        return agendaService.create(agenda);
    }

    @GetMapping("/get-all")
    public List<Agenda> getAll(){
        return agendaService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return agendaService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Agenda agenda){
        return agendaService.update(agenda);
    }

    @GetMapping("/get/{id}")
    public Agenda getById(@PathVariable("id") Integer id){
        return agendaService.getById(id);
    }

    @PostMapping("/{agendaId}/add-task")
    public boolean addTaskToAgenda(@PathVariable Integer agendaId, @RequestBody AgendaTask newTask) {
        return agendaService.addTaskToAgenda(agendaId, newTask);
    }
}

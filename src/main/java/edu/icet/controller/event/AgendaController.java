package edu.icet.controller.event;

import edu.icet.dto.event.Agenda;
import edu.icet.dto.event.AgendaTask;
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
    public boolean create(@RequestBody Agenda agenda) {
        return agendaService.create(agenda);
    }

    @GetMapping("/get-all")
    public List<Agenda> getAll() {
        return agendaService.getAll();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Agenda agenda) {
        return agendaService.update(agenda);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return agendaService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Agenda getById(@PathVariable Integer id) {
        return agendaService.getById(id);
    }

    @PostMapping("/{agendaId}/add-task")
    public boolean addTaskToAgenda(@PathVariable Integer agendaId, @RequestBody AgendaTask newTask) {
        return agendaService.addTaskToAgenda(agendaId, newTask);
    }

    @PutMapping("/{agendaId}/task/update/{taskId}")
    public boolean updateTask(@PathVariable Integer agendaId, @PathVariable Integer taskId, @RequestBody AgendaTask updatedTask) {
        return agendaService.updateTask(agendaId, taskId, updatedTask);
    }

    @DeleteMapping("/{agendaId}/task/delete/{taskId}")
    public boolean deleteTask(@PathVariable Integer agendaId, @PathVariable Integer taskId) {
        return agendaService.deleteTask(agendaId, taskId);
    }

    @GetMapping("/{agendaId}/task/{taskId}")
    public AgendaTask getTaskById(@PathVariable Integer agendaId, @PathVariable Integer taskId) {
        return agendaService.getTaskById(agendaId, taskId);
    }
}
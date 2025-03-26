package edu.icet.service.customer;

import edu.icet.dto.event.Agenda;
import edu.icet.dto.event.AgendaTask;

import java.util.List;

public interface AgendaService {
    boolean create(Agenda agenda);
    List<Agenda> getAll();
    boolean update(Agenda agenda);
    boolean delete(Integer id);
    Agenda getById(Integer id);
    boolean addTaskToAgenda(Integer agendaId, AgendaTask newTask);
    boolean updateTask(Integer agendaId, Integer taskId, AgendaTask updatedTask);
    boolean deleteTask(Integer agendaId, Integer taskId);
    AgendaTask getTaskById(Integer agendaId, Integer taskId);
}
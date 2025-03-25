package edu.icet.service.customer;

import edu.icet.dto.Agenda;
import edu.icet.dto.AgendaTask;

import java.util.List;

public interface AgendaService {
    boolean create(Agenda agenda);
    boolean update(Agenda agenda);
    boolean delete(Integer id);
    List<Agenda> getAll();
    Agenda getById(Integer id);
    boolean addTaskToAgenda(Integer agendaId, AgendaTask newTask);

}

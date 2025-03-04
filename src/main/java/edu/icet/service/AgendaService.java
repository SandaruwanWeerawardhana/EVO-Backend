package edu.icet.service;

import edu.icet.dto.Agenda;

import java.util.List;

public interface AgendaService {
    boolean createAgenda(Agenda agenda);
    boolean updateAgenda(Agenda agenda);
    boolean deleteAgenda(Integer id);
    List<Agenda> getAll();
    Agenda getAgendaById(Integer id);

}

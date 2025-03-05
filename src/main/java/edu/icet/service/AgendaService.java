package edu.icet.service;

import edu.icet.dto.Agenda;

import java.util.List;

public interface AgendaService {
    boolean create(Agenda agenda);
    boolean update(Agenda agenda);
    boolean delete(Integer id);
    List<Agenda> getAll();
    Agenda getById(Integer id);

}

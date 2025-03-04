package edu.icet.service;

import edu.icet.dto.Agenda;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface AgendaService {
    boolean create(Agenda agenda);
    boolean update(Agenda agenda);
    boolean delete(Integer id);
    List<Agenda> getAll();
    Agenda getById(Integer id);

}

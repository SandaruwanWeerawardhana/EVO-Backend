package edu.icet.service.customer.impl;

import edu.icet.dto.Agenda;
import edu.icet.service.customer.AgendaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgendaServiceImpl implements AgendaService {
    @Override
    public boolean create(Agenda agenda) {
        return false;
    }

    @Override
    public boolean update(Agenda agenda) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Agenda> getAll() {
        return List.of();
    }

    @Override
    public Agenda getById(Integer id) {
        return null;
    }
}

package edu.icet.service.customer.impl;

import edu.icet.dto.Agenda;
import edu.icet.service.customer.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AgendaServiceImpl implements AgendaService {
    private final List<Agenda> agendaList = new ArrayList<>();

    @Override
    public boolean create(Agenda agenda) {
        return agendaList.add(agenda);
    }

    @Override
    public boolean update(Agenda agenda) {
        for (Agenda a : agendaList) {
            if (a.getId().equals(agenda.getId())) {
                a.setDate(agenda.getDate());
                a.setTime(agenda.getTime());
                a.setAgendaDetail(agenda.getAgendaDetail());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Agenda a : agendaList) {
            if (a.getId().equals(id)) {
                agendaList.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Agenda> getAll() {
        return agendaList;
    }

    @Override
    public Agenda getById(Integer id) {
        for (Agenda a : agendaList) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}

package edu.icet.service.event.impl;

import edu.icet.dto.Wedding;
import edu.icet.service.event.WeddingEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class WeddingEventServiceImpl implements WeddingEventService {
    @Override
    public List<Wedding> getAll() {
        return List.of();
    }

    @Override
    public boolean add(Wedding wedding) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Wedding wedding) {
        return false;
    }

    @Override
    public Wedding get(String id) {
        return null;
    }

    @Override
    public List<Wedding> getByDate(LocalDate date) {
        return List.of();
    }
}

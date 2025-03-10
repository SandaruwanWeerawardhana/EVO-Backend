package edu.icet.service.supplier.impl;

import edu.icet.dto.Hall;
import edu.icet.dto.Profile;
import edu.icet.service.supplier.HallService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HallServiceImpl implements HallService {
    @Override
    public List<Hall> getAll(Profile profile) {
        return List.of();
    }

    @Override
    public Hall save(Hall hall) {
        return null;
    }

    @Override
    public Hall search(String query) {
        return null;
    }

    @Override
    public Boolean delete(Hall hall) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Hall update(Hall hall) {
        return null;
    }
}

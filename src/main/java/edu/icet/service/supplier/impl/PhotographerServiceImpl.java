package edu.icet.service.supplier.impl;

import edu.icet.dto.Photographer;
import edu.icet.service.supplier.PhotographerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotographerServiceImpl implements PhotographerService {
    @Override
    public void add(Photographer photographer) {

    }

    @Override
    public List<Photographer> getAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Photographer photographer) {

    }

    @Override
    public Photographer searchById(Long id) {
        return null;
    }
}

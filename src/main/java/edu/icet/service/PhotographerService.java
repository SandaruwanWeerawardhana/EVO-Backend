package edu.icet.service;

import edu.icet.dto.Photographer;

import java.util.List;

public interface PhotographerService {
    List<Photographer> getAll();
    void save(Photographer photographer);
    Photographer search(Photographer query);
    void update(Photographer photographer);
    void delete(Long id);
}

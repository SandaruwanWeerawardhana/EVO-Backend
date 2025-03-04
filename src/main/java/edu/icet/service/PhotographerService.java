package edu.icet.service;

import edu.icet.dto.Photographer;

import java.util.List;

public interface PhotographerService {
    void add(Photographer photographer);
    List<Photographer> getAll();
    void delete(Long id);
    void update(Photographer photographer);
    Photographer searchById(Long id);
}

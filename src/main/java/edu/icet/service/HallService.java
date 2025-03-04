package edu.icet.service;

import edu.icet.dto.Hall;
import edu.icet.dto.ProfilePreviousWork;

import java.util.List;

public interface HallService {
    List<Hall> getAll();
    Hall save(Hall hall);
    Hall search(String query);
    Boolean delete(Hall hall);
    Boolean delete(Long id);
    Hall update(Hall hall);
}

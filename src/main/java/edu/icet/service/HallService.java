package edu.icet.service;

import edu.icet.dto.Hall;
import java.util.List;

public interface HallService {
    List<Hall> getAll();
    Hall save(Hall hall);
    Boolean delete(Hall hall);
    Boolean delete(Long id);
    Hall update(Hall hall);
}

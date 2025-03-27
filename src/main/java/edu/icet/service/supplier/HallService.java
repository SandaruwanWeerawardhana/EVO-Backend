package edu.icet.service.supplier;

import edu.icet.dto.supplier.Hall;
import edu.icet.dto.supplier.Supplier;

import java.util.List;

public interface HallService {
    List<Hall> getAll();
    Hall save(Hall hall);
    Hall search(Hall hall);
    Boolean delete(Hall hall);
    Boolean delete(Long id);
    Hall update(Hall hall);
}

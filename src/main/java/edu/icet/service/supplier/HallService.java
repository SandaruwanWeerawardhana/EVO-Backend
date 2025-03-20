package edu.icet.service.supplier;

import edu.icet.dto.Hall;
import edu.icet.dto.Profile;
import edu.icet.entity.HallEntity;

import java.util.List;
import java.util.Optional;

public interface HallService {
    List<HallEntity> getAll(Profile profile);
    Hall save(Hall hall);
    Optional<HallEntity> search(Hall hall);
    Boolean delete(Hall hall);
    Boolean delete(Long id);
    Hall update(Hall hall);
}

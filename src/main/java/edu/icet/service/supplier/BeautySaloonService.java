package edu.icet.service.supplier;

import edu.icet.dto.BeautySaloon;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BeautySaloonService {
    List<BeautySaloon> getAll();
    BeautySaloon add(BeautySaloon beautySaloon);
    boolean delete(Long id);
    boolean update(BeautySaloon beautySaloon);
    BeautySaloon get(Long id);

}

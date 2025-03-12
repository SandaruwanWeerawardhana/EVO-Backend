package edu.icet.service.supplier;

import edu.icet.dto.BeautySaloon;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BeautySaloonService {
    List<BeautySaloon> getAll();
    List<BeautySaloon> add(BeautySaloon beautySaloon);
    boolean delete(String id);
    boolean update(BeautySaloon beautySaloon);
    BeautySaloon get(String id);
}

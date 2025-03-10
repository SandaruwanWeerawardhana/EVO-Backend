package edu.icet.service.supplier;

import edu.icet.dto.Pool;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PoolService {
    List <Pool> getAll();
    Pool save (Pool pool);
    Boolean delete (Long id);
    Boolean update (Pool pool);
}

package edu.icet.service;

import edu.icet.dto.Pool;

import java.util.List;

public interface PoolService {
    List <Pool> getAll();
    Pool save (Pool pool);
    Boolean delete (Long id);
    Boolean update (Pool pool);
}

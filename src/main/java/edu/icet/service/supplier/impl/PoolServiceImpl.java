package edu.icet.service.supplier.impl;

import edu.icet.dto.Pool;
import edu.icet.service.supplier.PoolService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoolServiceImpl implements PoolService {
    @Override
    public List<Pool> getAll() {
        return List.of();
    }

    @Override
    public Pool save(Pool pool) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean update(Pool pool) {
        return null;
    }
}

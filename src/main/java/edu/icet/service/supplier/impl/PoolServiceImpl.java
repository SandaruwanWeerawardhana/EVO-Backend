package edu.icet.service.supplier.impl;

import edu.icet.dto.Pool;
import edu.icet.service.supplier.PoolService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PoolServiceImpl implements PoolService {
    final ModelMapper mapper;
    private final ArrayList<Pool> pools = new ArrayList<>();

    @Override
    public List<Pool> getAll() {
        return pools;
    }

    @Override
    public Pool save(Pool pool) {
        pools.add(pool);
        return pool;
    }

    @Override
    public Boolean delete(Long id) {
        pools.removeIf(pool -> pool.getId().equals(id));
        return pools.isEmpty();
    }

    @Override
    public Boolean update(Pool pool) {
        if (pool == null || pool.getId() == null) return null;

        for (Pool bs : pools) {
            if (bs.getId().equals(pool.getId())) {
                int index = pools.indexOf(bs);
                pools.set(index, pool);
                return true;
            }
        }
        return false;
    }
}

package edu.icet.service.supplier.impl;

import edu.icet.dto.Pool;
import edu.icet.entity.PoolEntity;
import edu.icet.repository.PoolRepository;
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
    final PoolRepository repository;

    @Override
    public List<Pool> getAll() {
        return repository.findAll().stream().map(
                poolEntity -> mapper.map(poolEntity, Pool.class)
        ).toList();
    }

    @Override
    public Pool save(Pool pool) {
        return mapper.map(repository.save(mapper.map(pool, PoolEntity.class)), Pool.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return  true;
        }

        return false;
    }

    @Override
    public Boolean update(Pool pool) {
        if (repository.existsById(id)) {

            repository.save(mapper.map(pool, PoolEntity.class));

            return true;
        }

        return false;
    }
}

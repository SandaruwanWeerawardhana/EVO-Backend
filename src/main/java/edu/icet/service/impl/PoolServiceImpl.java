package edu.icet.service.impl;

import edu.icet.dto.Pool;
import edu.icet.service.PoolService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PoolServiceImpl  implements PoolService {
    final ModelMapper mapper;
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

package edu.icet.service.customer.impl;

import edu.icet.dto.Anniversary;
import edu.icet.service.customer.AnniversaryEventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnniversaryEventServiceImpl implements AnniversaryEventService {
    @Override
    public boolean add(Anniversary anniversary) {
        return false;
    }

    @Override
    public List<Anniversary> getAll() {
        return List.of();
    }

    @Override
    public boolean delete(Integer eventId) {
        return false;
    }

    @Override
    public boolean update(Anniversary anniversary) {
        return false;
    }

    @Override
    public Anniversary get(Integer eventId) {
        return null;
    }
}

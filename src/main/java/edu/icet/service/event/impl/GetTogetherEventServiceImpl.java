package edu.icet.service.event.impl;

import edu.icet.dto.GetTogether;
import edu.icet.service.event.GetTogetherEventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetTogetherEventServiceImpl implements GetTogetherEventService {
    @Override
    public void addGetTogether(GetTogether getTogether) {

    }

    @Override
    public void deleteGetTogether(Integer id) {

    }

    @Override
    public List<GetTogether> getAll() {
        return List.of();
    }

    @Override
    public void updateGetTogether(GetTogether getTogether) {

    }

    @Override
    public GetTogether searchById(Integer id) {
        return null;
    }
}

package edu.icet.service.event;

import edu.icet.dto.event.GetTogether;

import java.util.List;

public interface GetTogetherEventService {
    boolean add(GetTogether getTogether);
    boolean delete(Integer id);
    List<GetTogether> getAll();
    boolean update(GetTogether getTogether);
    GetTogether get(Integer id);
}

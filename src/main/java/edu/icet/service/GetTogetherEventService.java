package edu.icet.service;

import edu.icet.dto.GetTogether;

import java.util.List;

public interface GetTogetherEventService {
    void addGetTogether(GetTogether getTogether);
    void deleteGetTogether(Integer id);
    List<GetTogether> getAll();
    void updateGetTogether(GetTogether getTogether);
    GetTogether searchById(Integer id);
}

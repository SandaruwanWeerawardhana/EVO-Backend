package edu.icet.service;

import edu.icet.dto.Anniversary;

import java.util.List;

public interface AnniversaryEventService {
    void add(Anniversary anniversary);
    List<Anniversary> getAll();
    void delete(Integer eventId);
    void update(Anniversary anniversary);
    Anniversary searchById(Integer eventId);
}

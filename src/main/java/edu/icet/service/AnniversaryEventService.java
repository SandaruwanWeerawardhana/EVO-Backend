package edu.icet.service;

import edu.icet.dto.Anniversary;

import java.util.List;

public interface AnniversaryEventService {
    boolean add (Anniversary anniversary);
    List<Anniversary> getAll();
    boolean delete(Integer eventId);
    boolean update(Anniversary anniversary);
    Anniversary get(Integer eventId);
}

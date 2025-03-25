package edu.icet.service.customer;

import edu.icet.dto.event.Anniversary;

import java.util.List;

public interface AnniversaryEventService {
    boolean add (Anniversary anniversary);
    List<Anniversary> getAll();
    boolean delete(Long eventId);
    boolean update(Anniversary anniversary);
    Anniversary get(Long eventId);
}

package edu.icet.service;

import edu.icet.dto.Wedding;

import java.time.LocalDate;
import java.util.List;

public interface WeddingEventService {
    List<Wedding> getAll();
    boolean add(Wedding wedding);
    boolean delete(String id);
    boolean update(Wedding wedding);
    Wedding get(String id);
    List<Wedding> getByVenue(String venue);
    List<Wedding> getByDate(LocalDate date);
}

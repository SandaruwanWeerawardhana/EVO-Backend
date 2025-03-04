package edu.icet.service;

import edu.icet.dto.Catering;
import java.util.List;
import java.util.Optional;

public interface CateringService {
    Catering addCatering(Catering cateringDTO);
    Catering updateCatering(Integer cateringId, Catering cateringDTO);
    Optional<Catering> getCateringById(Integer cateringId);
    List<Catering> getAllCatering();
    void deleteCatering(Integer cateringId);
    List<Catering> getCateringBySupplierId(Integer supplierId);
}
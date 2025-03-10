package edu.icet.service.supplier;

import edu.icet.dto.Catering;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CateringService {
    Catering addCatering(Catering cateringDTO);
    Catering updateCatering(Catering cateringDTO);
    Optional<Catering> getCateringById(Integer cateringId);
    List<Catering> getAllCatering();
    void deleteCatering(Integer cateringId);
    List<Catering> getCateringBySupplierId(Integer supplierId);
}
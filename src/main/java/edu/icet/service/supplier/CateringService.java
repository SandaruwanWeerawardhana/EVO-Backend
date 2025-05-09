package edu.icet.service.supplier;

import edu.icet.dto.supplier.Catering;
import edu.icet.dto.supplier.Meal;
import edu.icet.dto.supplier.Supplier;

import java.util.List;
import java.util.Optional;

public interface CateringService {
    Catering addCatering(Catering catering);
    Catering updateCatering(Catering catering);
    Optional<Catering> getCateringById(Long cateringId);
    List<Catering> getAllCatering();
    void deleteCatering(Long cateringId);
    List<Catering> getCateringBySupplierId(Supplier supplier);

    List<Catering> getCateringWIthMeals(List<Meal> meals);
}
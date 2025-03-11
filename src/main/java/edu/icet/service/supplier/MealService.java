package edu.icet.service.supplier;

import edu.icet.dto.Meal;
import edu.icet.util.MealType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MealService {
    List<Meal> getAll();
    Meal save(Meal meal);
    Boolean delete(Meal meal);
    Boolean delete(Long id);
    Meal update (Meal meal);
    List<Meal> search(MealType type);
    List<Meal> search(String name);
    Meal search(Long id);
}

package edu.icet.service.supplier;

import edu.icet.dto.Meal;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MealService {
    List<Meal> getAll();
    Meal save(Meal meal);
    Boolean delete(Meal meal);
    Boolean delete(Long id);
    Meal update (Meal meal);
}

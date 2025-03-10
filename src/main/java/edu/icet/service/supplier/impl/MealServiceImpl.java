package edu.icet.service.supplier.impl;

import edu.icet.dto.Meal;
import edu.icet.service.supplier.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MealServiceImpl implements MealService {
    @Override
    public List<Meal> getAll() {
        return List.of();
    }

    @Override
    public Meal save(Meal meal) {
        return null;
    }

    @Override
    public Boolean delete(Meal meal) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Meal update(Meal meal) {
        return null;
    }
}

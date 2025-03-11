package edu.icet.service.supplier.impl;

import edu.icet.dto.Meal;
import edu.icet.service.supplier.MealService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {
    ArrayList<Meal> meals = new ArrayList<>();
    final ModelMapper modelMapper;

    @Override
    public List<Meal> getAll() {
          ArrayList<Meal> mList = new ArrayList<>();
          //TODO get data from repo
        return mList;
    }

    @Override
    public Meal save(Meal meal) {
    meals.add(meal);
        return meal;
    }

    @Override
    public Boolean delete(Meal meal) {
        return meals.remove(meal);
    }

    @Override
    public Boolean delete(Long id) {
        for (int i = 0; i < meals.size(); i++) {
            if(meals.get(i).getId().equals(id)){
                meals.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Meal update(Meal meal) {
    for (int i = 0; i < meals.size(); i++) {
        if(meals.get(i).getId().equals(meal.getId())){
            meals.add(i,meal);
            return meal;
        }
    }
        return null;
    }
}

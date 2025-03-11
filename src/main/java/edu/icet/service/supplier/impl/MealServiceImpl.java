package edu.icet.service.supplier.impl;

import edu.icet.dto.Meal;
import edu.icet.service.supplier.MealService;
import edu.icet.util.MealType;
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

    @Override
    public List<Meal> search(MealType type) {
        ArrayList<Meal> mList = new ArrayList<>();
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getMealType().equals(type)){
                mList.add(meals.get(i));
            }
        }
        return mList;
    }

    @Override
    public List<Meal> search(String name) {
        ArrayList<Meal> mList = new ArrayList<>();
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getName().equals(name)){
                mList.add(meals.get(i));
            }
        }
        return mList;
    }

    @Override
    public Meal search(Long id) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getId().equals(id)){
                return meals.get(i);
            }
        }
        return null;
    }
}

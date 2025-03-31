package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Meal;
import edu.icet.entity.supplier.MealEntity;
import edu.icet.repository.supplier.MealRepository;
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
    private final MealRepository mealRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Meal> getAll() {
        List<MealEntity> all = mealRepository.findAll();

        List<Meal> mealList = new ArrayList<>();

        all.forEach(mealEntity -> {
            mealList.add(modelMapper.map(mealEntity, Meal.class));
        });
        return mealList;
    }

    @Override
    public Meal save(Meal meal) {
        return modelMapper.map(mealRepository.save(modelMapper.map(meal, MealEntity.class)), Meal.class);
    }

    @Override
    public Boolean delete(Meal meal) {
        if (mealRepository.existsById(meal.getId())){
            mealRepository.delete(modelMapper.map(meal, MealEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        if (mealRepository.existsById(id)) {
            mealRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Meal update(Meal meal) {
        return modelMapper.map(mealRepository.save(modelMapper.map(meal, MealEntity.class)), Meal.class);
    }

    @Override
    public List<Meal> search(MealType type) {
        List<MealEntity> byMealType = mealRepository.findByMealType(type);

        List<Meal> mealList = new ArrayList<>();

        byMealType.forEach(mealEntity -> {
            mealList.add(modelMapper.map(mealEntity,Meal.class));
        });
        return mealList;
    }

    @Override
    public List<Meal> search(String name) {
        List<MealEntity> byName = mealRepository.findByName(name);

        List<Meal> mealList = new ArrayList<>();

        byName.forEach(mealEntity -> {
            mealList.add(modelMapper.map(mealEntity,Meal.class));
        });
        return mealList;
    }

    @Override
    public Meal search(Long id) {
        return modelMapper.map(mealRepository.findAllById(id),Meal.class);
    }
}

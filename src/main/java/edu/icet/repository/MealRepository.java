package edu.icet.repository;

import edu.icet.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<MealEntity, Long> {
    List<MealEntity> findByMealType(String mealType);
    List<MealEntity> findByNameContainingIgnoreCase(String name);
    List<MealEntity> findByPricePerPersonLessThanEqual(Double price);
    List<MealEntity> findByPricePerPersonGreaterThanEqual(Double price);
    List<MealEntity> findByName(String name);
    MealEntity findAllById(Long id);
}

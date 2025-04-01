package edu.icet.repository.supplier;

import edu.icet.entity.supplier.CateringEntity;
import edu.icet.entity.supplier.MealEntity;
import edu.icet.entity.supplier.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CateringRepository extends JpaRepository <CateringEntity, Long>  {
    List<CateringEntity> findByMealsIn(List<MealEntity> meals);
}

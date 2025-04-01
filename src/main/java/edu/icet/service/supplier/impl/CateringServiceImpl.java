package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Catering;
import edu.icet.dto.supplier.Meal;
import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.CateringEntity;
import edu.icet.entity.supplier.MealEntity;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.repository.supplier.CateringRepository;
import edu.icet.service.supplier.CateringService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CateringServiceImpl implements CateringService {
    final CateringRepository repository;
    final ModelMapper mapper;


    @Override
    public Catering addCatering(Catering catering) {
        repository.save(mapper.map(catering, CateringEntity.class));
        return catering;
    }

    @Override
    public Catering updateCatering(Catering catering) {

        return mapper.map(repository.save(mapper.map(catering, CateringEntity.class)), Catering.class);
    }

    @Override
    public Optional<Catering> getCateringById(Long cateringId) {
        return repository.findById(cateringId).map(entity -> mapper.map(entity, Catering.class));

    }

    @Override
    public List<Catering> getAllCatering() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, Catering.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCatering(Long cateringId) {
        if (repository.existsById(cateringId)) {
            repository.deleteById(cateringId);
        }
    }

    @Override
    public List<Catering> getCateringBySupplierId(Supplier supplier) {
//        return repository.findBySupplier(mapper.map(supplier, SupplierEntity.class)).stream()
//                .map(entity -> mapper.map(entity, Catering.class))
//                .collect(Collectors.toList());

        return null;
    }

    @Override
    public List<Catering> getCateringWIthMeals(List<Meal> meals) {

        return repository.findByMealsIn(
                    meals
                        .stream()
                        .map(meal -> mapper.map(meal, MealEntity.class))
                        .toList()
                )
                .stream()
                .map(cateringEntity -> mapper.map(cateringEntity, Catering.class))
                .toList();
    }

}
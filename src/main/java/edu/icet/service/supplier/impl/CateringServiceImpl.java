package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Catering;
import edu.icet.entity.supplier.CateringEntity;
import edu.icet.repository.supplier.CateringRepository;
import edu.icet.service.supplier.CateringService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public Optional<Catering> getCateringById(Integer cateringId) {
        return repository.findById(cateringId).map(entity -> mapper.map(entity, Catering.class));

    }

    @Override
    public List<Catering> getAllCatering() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, Catering.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCatering(Integer cateringId) {
        if (repository.existsById(cateringId)) {
            repository.deleteById(cateringId);
        }
    }

    @Override
    public List<Catering> getCateringBySupplierId(Integer supplierId) {
        return repository.findBySupplierId(supplierId).stream()
                .map(entity -> mapper.map(entity, Catering.class))
                .collect(Collectors.toList());
    }

}
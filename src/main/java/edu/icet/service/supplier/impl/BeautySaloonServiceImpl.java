package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautySaloon;
import edu.icet.entity.BeautySaloonEntity;
import edu.icet.repository.BeautySaloonRepository;
import edu.icet.repository.SupplierRepository;
import edu.icet.service.supplier.BeautySaloonService;
import edu.icet.service.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeautySaloonServiceImpl implements BeautySaloonService {

    private final ModelMapper mapper;
    private final BeautySaloonRepository repository;
    private final SupplierRepository supplierRepository;

    @Override
    public List<BeautySaloon> getAll() {
        return repository.findAll()
                .stream()
                .map(beautySaloonEntity -> mapper.map(beautySaloonEntity, BeautySaloon.class))
                .toList();
    }

    @Override
    public BeautySaloon add(BeautySaloon beautySaloon) {
        return mapper.map(repository.save(mapper.map(beautySaloon, BeautySaloonEntity.class)), BeautySaloon.class);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean update(BeautySaloon beautySaloon) {
        if (repository.existsById(beautySaloon.getId())) {
            repository.save(mapper.map(beautySaloon, BeautySaloonEntity.class));
            return true;
        }

        return false;
    }

    @Override
    public BeautySaloon get(Long id) {
        return mapper.map(repository.findById(id).orElseThrow(
                () ->  new IllegalArgumentException("Beauty Salon object not found")
        ), BeautySaloon.class);
    }


}

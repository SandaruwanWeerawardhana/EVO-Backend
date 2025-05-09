package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.customer.UserEntity;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.repository.customer.UserRepository;
import edu.icet.repository.supplier.SupplierRepository;
import edu.icet.service.supplier.SupplierService;
import edu.icet.service.system.CategoryService;
import edu.icet.util.CategoryType;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository
                .findAll()
                .stream()
                .map(supplier -> mapper.map(supplier, Supplier.class))
                .toList();
    }

    @Override
    public List<Supplier> getByCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null or blank");
        }
        CategoryType categoryEnum = CategoryType.valueOf(category.toUpperCase());

        return repository.findAllByCategory(categoryEnum)
                .stream()
                .map(supplierEntity -> mapper.map(supplierEntity, Supplier.class))
                .collect(Collectors.toList());
    }

    @Override
    public Supplier searchSupplier(Long id) {
        SupplierEntity supplierEntity = supplierRepository.findById(id).orElse(null);

        if (repository.existsByContactNumber(supplier.getContactNumber())) {
            throw new IllegalArgumentException("phone number is already exists");
        }

        if (repository.existsByBusinessName(supplier.getBusinessName())){
            throw new IllegalArgumentException("Business name is already exists");
        }

        repository.save(mapper.map(supplier, SupplierEntity.class));
        return supplierEntity != null ? mapper.map(supplierEntity, Supplier.class) : null;

    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (supplierRepository.existsById(supplier.getId())) {
            return mapper.map(supplierRepository.save(mapper.map(supplier, SupplierEntity.class)), Supplier.class);

        }

        throw new IllegalArgumentException("Supplier does not exist!");
    }

    @Override
    public Boolean deleteSupplier(Long supplierID) {
        if (supplierRepository.existsById(supplierID)) {

            UserEntity userEntity = userRepository.findBySupplier(supplierRepository.findById(supplierID).orElse(null));
            userRepository.deleteById(userEntity.getUserId());

            supplierRepository.deleteById(supplierID);

            return true;
        }

        throw new IllegalArgumentException("Supplier does not exist!");

    }

}

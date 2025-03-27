package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Supplier;
import edu.icet.entity.supplier.SupplierEntity;
import edu.icet.repository.supplier.SupplierRepository;
import edu.icet.service.supplier.SupplierService;
import edu.icet.service.system.CategoryService;
import edu.icet.util.CategoryType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    final ModelMapper mapper;
    final CategoryService categoryService;
    final SupplierRepository repository;

    @Override
    public List<Supplier> getAll() {
        return repository.findAll()
                .stream()
                .map(supplierEntity -> mapper.map(supplierEntity, Supplier.class))
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
    public void add(Supplier supplier) {

        if (repository.existsByEmail(supplier.getEmail())){
            throw new IllegalArgumentException("Email is already exits");
        }

        if (repository.existsByContactNumber(supplier.getContactNumber())) {
            throw new IllegalArgumentException("phone number is already exists");
        }

        if (repository.existsByBusinessName(supplier.getBusinessName())){
            throw new IllegalArgumentException("Business name is already exists");
        }

        repository.save(mapper.map(supplier, SupplierEntity.class));
    }


    @Override
    public Supplier search(Supplier query) {
        return getAll().stream()
                .filter(s ->
                        (query.getUserId() != 0 && Objects.equals(s.getUserId(), query.getUserId())) ||
                                (query.getBusinessName() != null && s.getBusinessName().equalsIgnoreCase(query.getBusinessName())) ||
                                (query.getEmail() != null && s.getEmail().equalsIgnoreCase(query.getEmail())) ||
                                (query.getContactNumber() != null && s.getContactNumber().equals(query.getContactNumber()))
                )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
    }

    @Override
    public void update(Supplier supplier) {
        if (repository.existsById(supplier.getUserId())) {
            repository.save(mapper.map(supplier, SupplierEntity.class));
            return;
        }
        throw new IllegalArgumentException("Supplier does not exist!");
    }

    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new IllegalArgumentException("Supplier does not exist!");
    }
}

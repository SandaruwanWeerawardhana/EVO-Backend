package edu.icet.service.supplier.impl;

import edu.icet.dto.Supplier;
import edu.icet.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    final ModelMapper mapper;
    private final List<Supplier> supplierList = new ArrayList<>();

    @Override
    public List<Supplier> getAll() {
        return new ArrayList<>(supplierList);
    }

    @Override
    public void add(Supplier supplier) {
        Optional<Supplier> existingSupplier = supplierList.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(supplier.getEmail()) || s.getPhoneNumber().equals(supplier.getPhoneNumber()))
                .findFirst();

        if (existingSupplier.isPresent()) {
            return;
        }

        supplier.setUserId((long) (supplierList.size() + 1));
        supplierList.add(supplier);
    }

    @Override
    public Supplier search(Supplier query) {
        return supplierList.stream()
                .filter(s ->
                        (query.getUserId() != 0 && Objects.equals(s.getUserId(), query.getUserId())) ||
                                (query.getProfileId() != 0 && Objects.equals(s.getProfileId(), query.getProfileId())) ||
                                (query.getBusinessName() != null && s.getBusinessName().equalsIgnoreCase(query.getBusinessName())) ||
                                (query.getEmail() != null && s.getEmail().equalsIgnoreCase(query.getEmail())) ||
                                (query.getPhoneNumber() != null && s.getPhoneNumber().equals(query.getPhoneNumber()))
                )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));
    }

    @Override
    public void update(Supplier supplier) {
        for (int i = 0; i < supplierList.size(); i++) {
            if (Objects.equals(supplierList.get(i).getUserId(), supplier.getUserId())) {
                supplierList.set(i, supplier);
                return;
            }
        }
    }

    @Override
    public void delete(Long id) {
        supplierList.removeIf(s -> Objects.equals(s.getUserId(), id));
    }
}

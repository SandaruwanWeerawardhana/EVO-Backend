package edu.icet.service.supplier.impl;

import edu.icet.dto.Supplier;
import edu.icet.service.supplier.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService {
    @Override
    public List<Supplier> getAll() {
        return List.of();
    }

    @Override
    public boolean addSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public Supplier searchSupplier(String qurey) {
        return null;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(Long id) {
        return false;
    }
}

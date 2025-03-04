package edu.icet.service;

import edu.icet.dto.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAll();

    boolean addSupplier(Supplier supplier);

    Supplier searchSupplier(String qurey);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplier(Long id);

}

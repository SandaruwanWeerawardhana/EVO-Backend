package edu.icet.service;

import edu.icet.dto.Supplier;
import java.util.List;

public interface SupplierService {
    List<Supplier> getAll();

    void add(Supplier supplier);

    Supplier search(Supplier query);

    void update(Supplier supplier);

    void delete(Long id);
}

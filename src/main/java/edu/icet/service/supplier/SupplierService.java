package edu.icet.service.supplier;

import edu.icet.dto.Supplier;
import java.util.List;

public interface SupplierService {
    List<Supplier> getAll();

    List<Supplier> getByCategory(String category);

    void add(Supplier supplier);

    Supplier search(Supplier query);

    void update(Supplier supplier);

    void delete(Long id);
}

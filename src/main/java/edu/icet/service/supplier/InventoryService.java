package edu.icet.service.supplier;

import edu.icet.dto.Inventory;
import edu.icet.dto.Supplier;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAll();

    Boolean add(Inventory inventory);

    List<Inventory> search(String name);

    Boolean update(Inventory inventory);

    Boolean delete(Long id);
}

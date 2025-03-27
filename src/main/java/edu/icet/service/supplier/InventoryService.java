package edu.icet.service.supplier;


import edu.icet.dto.supplier.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAll();

    Boolean add(Inventory inventory);

    List<Inventory> search(Long id);

    Boolean update(Inventory inventory);

    Boolean delete(Long id);
}

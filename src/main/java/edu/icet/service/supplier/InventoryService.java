package edu.icet.service.supplier;


import edu.icet.dto.supplier.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAll();

    Inventory add(Inventory inventory);

    Inventory search(Long id);

    Inventory update(Inventory inventory);

    Boolean delete(Long id);
}

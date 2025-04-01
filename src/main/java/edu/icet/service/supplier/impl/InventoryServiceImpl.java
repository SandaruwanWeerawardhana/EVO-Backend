package edu.icet.service.supplier.impl;

import edu.icet.dto.supplier.Inventory;
import edu.icet.entity.supplier.InventoryEntity;
import edu.icet.repository.supplier.InventoryRepository;
import edu.icet.service.supplier.InventoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final ModelMapper mapper;
    private final InventoryRepository repository;

    @Override
    public List<Inventory> getAll() {
        List<InventoryEntity> entity = repository.findAll();
        List<Inventory> inventoryList = new ArrayList<>();
        entity.forEach(e -> inventoryList.add(mapper.map(e,Inventory.class)));
        return inventoryList;
    }

    @Override
    public Inventory add(Inventory inventory) {
        return mapper.map(repository.save(mapper.map(inventory, InventoryEntity.class)), Inventory.class);
    }

    @Override
    public Inventory search(Long id) {
        InventoryEntity inventory = repository.findById(id).orElse(null);

        return inventory != null
                ? mapper.map(inventory, Inventory.class)
                : null;
    }

    @Override
    public Inventory update(Inventory inventory) {
        if (repository.existsById(inventory.getInventoryID())) {
            return mapper.map(repository.save(mapper.map(inventory, InventoryEntity.class)), Inventory.class);
        }

        throw new IllegalArgumentException("Inventory does not exist!");
    }

    @Override
    public Boolean delete(Long id) {
        if(id==null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

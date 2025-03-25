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
    public Boolean add(Inventory inventory) {
        if(inventory==null){
            return false;
        }
        repository.save(mapper.map(inventory, InventoryEntity.class));
        return true;
    }

    @Override
    public List<Inventory> search(Long id) {
        if(id==null){
            return null;
        }
        List<InventoryEntity> entity = Collections.singletonList(repository.findByInventoryId(id));
        List<Inventory> inventoryList = new ArrayList<>();
        entity.forEach(e -> inventoryList.add(mapper.map(e,Inventory.class)));
        return inventoryList;
    }

    @Override
    public Boolean update(Inventory inventory) {
        if(inventory==null){
            return false;
        }
        repository.save(mapper.map(inventory, InventoryEntity.class));
        return true;
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

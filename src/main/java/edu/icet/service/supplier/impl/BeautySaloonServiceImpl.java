package edu.icet.service.supplier.impl;

import edu.icet.dto.BeautySaloon;
import edu.icet.service.supplier.BeautySaloonService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeautySaloonServiceImpl implements BeautySaloonService {
    @Override
    public List<BeautySaloon> getAll() {
        return List.of();
    }

    @Override
    public boolean add(BeautySaloon beautySaloon) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(BeautySaloon beautySaloon) {
        return false;
    }

    @Override
    public List<BeautySaloon> getByName(String name) {
        return List.of();
    }

    @Override
    public BeautySaloon get(String id) {
        return null;
    }
}

package edu.icet.service.supplier.impl;

import edu.icet.dto.Catering;
import edu.icet.service.supplier.CateringService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CateringServiceImpl implements CateringService {
    @Override
    public Catering addCatering(Catering cateringDTO) {
        return null;
    }

    @Override
    public Catering updateCatering(Catering cateringDTO) {
        return null;
    }

    @Override
    public Optional<Catering> getCateringById(Integer cateringId) {
        return Optional.empty();
    }

    @Override
    public List<Catering> getAllCatering() {
        return List.of();
    }

    @Override
    public void deleteCatering(Integer cateringId) {

    }

    @Override
    public List<Catering> getCateringBySupplierId(Integer supplierId) {
        return List.of();
    }
}

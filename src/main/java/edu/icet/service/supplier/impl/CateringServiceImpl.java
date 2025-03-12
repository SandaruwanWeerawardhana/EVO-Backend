package edu.icet.service.supplier.impl;

import edu.icet.dto.Catering;
import edu.icet.service.supplier.CateringService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CateringServiceImpl implements CateringService {
    final List<Catering> cateringList = new ArrayList<>();

    @Override
    public Catering addCatering(Catering catering) {
        cateringList.add(catering);
        return catering;
    }

    @Override
    public Catering updateCatering(Catering catering) {
        for (int i = 0; i < cateringList.size(); i++) {
            if (cateringList.get(i).getCateringId().equals(catering.getCateringId())) {
                cateringList.set(i, catering);
                return catering;
            }
        }
        throw new RuntimeException("Catering service not found");
    }

    @Override
    public Optional<Catering> getCateringById(Integer cateringId) {
        return cateringList.stream()
                .filter(catering -> catering.getCateringId().equals(cateringId))
                .findFirst();
    }

    @Override
    public List<Catering> getAllCatering() {
        return new ArrayList<>(cateringList);
    }

    @Override
    public void deleteCatering(Integer cateringId) {
        cateringList.removeIf(catering -> catering.getCateringId().equals(cateringId));
    }

    @Override
    public List<Catering> getCateringBySupplierId(Integer supplierId) {
        List<Catering> result = new ArrayList<>();
        for (Catering catering : cateringList) {
            if (catering.getSupplierId().equals(supplierId)) {
                result.add(catering);
            }
        }
        return result;
    }
}
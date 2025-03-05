package edu.icet.service.impl;

import edu.icet.dto.Catering;
import edu.icet.service.CateringService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CateringServiceImpl implements CateringService {
    final CateringDao cateringDao;

    @Override
    public Catering addCatering(Catering cateringDTO) {
        return CateringDao.save(catering);
    }

    @Override
    public Catering updateCatering(Catering cateringDTO) {
        if (catering.getCateringId() == null || !CateringDao.existsById(catering.getCateringId())) {
            throw new EntityNotFoundException("Catering service not found");
        }
        return CateringDao.save(catering);
    }

    @Override
    public Optional<Catering> getCateringById(Integer cateringId) {
        return CateringDao.findById(cateringId);
    }

    @Override
    public List<Catering> getAllCatering() {
        return CateringDao.findAll();
    }

    @Override
    public void deleteCatering(Integer cateringId) {
        if (!CateringDao.existsById(cateringId)) {
            throw new EntityNotFoundException("Catering service not found");
        }
        CateringDao.deleteById(cateringId);
    }

    @Override
    public List<Catering> getCateringBySupplierId(Integer supplierId) {
        return CateringDao.findBySupplierId(supplierId);
    }
}
package edu.icet.service.impl;

import edu.icet.dto.Terms;
import edu.icet.service.TermsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TermsServiceImpl implements TermsService {
    final TermsDao termsDao;

    @Override
    public Terms addTerms(Terms terms) {
        terms.setLastUpdated(LocalDateTime.now());
        return termsDao.save(terms);
    }

    @Override
    public Terms updateTerms(Terms terms) {
        if (!termsDao.existsById(terms.getTermId().intValue())) {
            throw new EntityNotFoundException("Terms not found with ID: " + terms.getTermId());
        }
        terms.setLastUpdated(LocalDateTime.now());
        return termsDao.save(terms);
    }

    @Override
    public Optional<Terms> getTermsById(Integer termId) {
        return termsDao.findById(termId);
    }

    @Override
    public List<Terms> getTermsByProfileId(Integer profileId) {
        return termsDao.findByProfileId(profileId);
    }

    @Override
    public void deleteTerms(Integer termId) {
        if (!termsDao.existsById(termId)) {
            throw new EntityNotFoundException("Terms not found with ID: " + termId);
        }
        termsDao.deleteById(termId);
    }

    @Override
    public Optional<Terms> getActiveTerms(Integer profileId) {
        return termsDao.findByProfileIdAndIsActiveTrue(profileId);
    }
}
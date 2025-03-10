package edu.icet.service.system.impl;

import edu.icet.dto.Terms;
import edu.icet.service.system.TermsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TermsServiceImpl implements TermsService {
    @Override
    public Terms addTerms(Terms terms) {
        return null;
    }

    @Override
    public Terms updateTerms(Terms terms) {
        return null;
    }

    @Override
    public Optional<Terms> getTermsById(Integer termId) {
        return Optional.empty();
    }

    @Override
    public List<Terms> getTermsByProfileId(Integer profileId) {
        return List.of();
    }

    @Override
    public void deleteTerms(Integer termId) {

    }

    @Override
    public Optional<Terms> getActiveTerms(Integer profileId) {
        return Optional.empty();
    }
}

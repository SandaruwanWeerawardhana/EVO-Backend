package edu.icet.service.system.impl;

import edu.icet.dto.Terms;
import edu.icet.service.system.TermsService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TermsServiceImpl implements TermsService {
    final List<Terms> termsList = new ArrayList<>();

    @Override
    public Terms addTerms(Terms terms) {
        termsList.add(terms);
        return terms;
    }

    @Override
    public Terms updateTerms(Terms terms) {
        deleteTerms(terms.getTermId().intValue());
        termsList.add(terms);
        return terms;
    }

    @Override
    public Optional<Terms> getTermsById(Integer termId) {
        return termsList.stream()
                .filter(terms -> terms.getTermId().equals(termId.longValue()))
                .findFirst();
    }

    @Override
    public List<Terms> getTermsByProfileId(Integer profileId) {
        return termsList.stream()
                .filter(terms -> terms.getProfileId().equals(profileId.longValue()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTerms(Integer termId) {
        termsList.removeIf(terms -> terms.getTermId().equals(termId.longValue()));
    }

    @Override
    public Optional<Terms> getActiveTerms(Integer profileId) {
        return termsList.stream()
                .filter(terms -> terms.getProfileId().equals(profileId.longValue()) && terms.getIsActive())
                .findFirst();
    }
}
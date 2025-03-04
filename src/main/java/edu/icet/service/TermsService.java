package edu.icet.service;

import edu.icet.dto.Terms;
import java.util.List;
import java.util.Optional;

public interface TermsService {
    Terms addTerms(Terms terms);
    Terms updateTerms(Terms terms);
    Optional<Terms> getTermsById(Integer termId);
    List<Terms> getTermsByProfileId(Integer profileId);
    void deleteTerms(Integer termId);
    Optional<Terms> getActiveTerms(Integer profileId);
}
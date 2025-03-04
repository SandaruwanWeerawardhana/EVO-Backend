package edu.icet.service;

import edu.icet.dto.Terms;
import java.util.List;
import java.util.Optional;

public interface TermsService {
    Terms addTerms(Terms termsDTO);
    Terms updateTerms(Long termId, Terms termsDTO);
    Optional<Terms> getTermsById(Long termId);
    List<Terms> getTermsByProfileId(Long profileId);
    void deleteTerms(Long termId);
    Optional<Terms> getActiveTerms(Long profileId);
}
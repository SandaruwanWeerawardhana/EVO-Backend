package edu.icet.service;

import edu.icet.dto.VerificationRequest;

import java.util.List;

public interface VerificationRequestService {

 boolean saveVerificationRequest(VerificationRequest request);
 VerificationRequest findVerificationrequestbyId(Long id);
 List<VerificationRequest> getAllVerificationRequest();
 boolean deleteVerificationRequest(Long id);
 boolean updateVerificationRequest(VerificationRequest request);

}

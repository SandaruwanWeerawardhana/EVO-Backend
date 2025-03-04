package edu.icet.service;

import java.util.List;

public interface VerificationRequestService {

 VerificationRequestService saveVerificationRequest(VerificationRequestService request);
 VerificationRequestService findVerificationrequestbyId(Long id);
 List<VerificationRequestService> getAllVerificationRequest();
 boolean deleteVerificationRequest(Long id);
 VerificationRequestService updateVerificationRequest(VerificationRequestService request);

}

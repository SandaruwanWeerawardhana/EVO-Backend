package edu.icet.service.admin.impl;

import edu.icet.dto.VerificationRequest;
import edu.icet.service.admin.VerificationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Primary
@RequiredArgsConstructor
public class VerificationRequestServiceImpl implements VerificationRequestService {

    List<VerificationRequest> verificationRequests = new ArrayList<>();

    @Override
    public boolean saveVerificationRequest(VerificationRequest request) {
        if (request == null) {
            return false;
        } else {
            return verificationRequests.add(request);

        }
    }

    @Override
    public VerificationRequest findVerificationrequestById(Long id) {
        for (VerificationRequest request : verificationRequests) {
            if (request.getRequestID().equals(id)) {
                return request;
            }
        }
        return null;
    }

    @Override
    public List<VerificationRequest> getAllVerificationRequest() {
        if(verificationRequests!=null){
            return new ArrayList<>(verificationRequests);
        }
        return null;        
    }

    @Override
    public boolean deleteVerificationRequest(Long id) {
        if (id == null) {
            return false;
        } else {
            return verificationRequests.removeIf(verificationRequest1 -> Objects.equals(verificationRequest1.getRequestID(), id));
        }
    }

    @Override
    public boolean updateVerificationRequest(Long requestID, VerificationRequest request) {
        if (requestID == null || request == null) {
            return false;
        } else {
            for (VerificationRequest request1 : verificationRequests) {
                if (request1.getRequestID().equals(requestID)) {
                    request1.setResponseDate(request.getResponseDate());
                    request1.setSubmissionDate(request.getSubmissionDate());
                    request1.setStatus(request.getStatus());
                    request1.setVerificationDocument(request.getVerificationDocument());
                    request1.setName(request.getName());
                    request1.setEmail(request.getEmail());
                    request1.setPhoneNumber(request.getPhoneNumber());
                    return true;
                }
            }
            return false;
        }
    }
}


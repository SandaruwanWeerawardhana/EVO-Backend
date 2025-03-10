package edu.icet.service.supplier;

import edu.icet.dto.Profile;
import edu.icet.dto.ProfilePreviousWork;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfilePreviousWorkService {
    List<ProfilePreviousWork> getAll(Profile profile);
    ProfilePreviousWork save(ProfilePreviousWork profilePreviousWork);
    Boolean delete(Long id);
    ProfilePreviousWork search(String query);
    Boolean delete(ProfilePreviousWork profilePreviousWork);
    ProfilePreviousWork update(ProfilePreviousWork profilePreviousWork);
}

package edu.icet.service.supplier;

import edu.icet.dto.Profile;
import edu.icet.dto.ProfilePreviousWork;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProfilePreviousWorkService {
    List<ProfilePreviousWork> getAll(Profile profile);
    boolean save(ProfilePreviousWork profilePreviousWork);
    Boolean delete(Long id);
    ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork);
    boolean update(ProfilePreviousWork profilePreviousWork);
}

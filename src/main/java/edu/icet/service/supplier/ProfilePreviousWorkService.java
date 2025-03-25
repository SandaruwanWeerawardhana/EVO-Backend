package edu.icet.service.supplier;

import edu.icet.dto.system.Profile;
import edu.icet.dto.supplier.ProfilePreviousWork;

import java.util.List;

public interface ProfilePreviousWorkService {
    List<ProfilePreviousWork> getAll(Profile profile);
    boolean save(ProfilePreviousWork profilePreviousWork);
    Boolean delete(Long id);
    ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork);
    boolean update(ProfilePreviousWork profilePreviousWork);
}

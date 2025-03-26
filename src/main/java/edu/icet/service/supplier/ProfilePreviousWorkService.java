package edu.icet.service.supplier;

import edu.icet.dto.supplier.ProfilePreviousWork;
import edu.icet.dto.supplier.Supplier;

import java.util.List;

public interface ProfilePreviousWorkService {
    List<ProfilePreviousWork> getAll();
    boolean save(ProfilePreviousWork profilePreviousWork);
    Boolean delete(Long id);
    ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork);
    boolean update(ProfilePreviousWork profilePreviousWork);




}

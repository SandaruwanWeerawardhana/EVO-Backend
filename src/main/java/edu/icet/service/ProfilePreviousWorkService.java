package edu.icet.service;

import edu.icet.dto.ProfilePreviousWork;

import java.util.List;

public interface ProfilePreviousWorkService {
    List<ProfilePreviousWork> getAll();
    ProfilePreviousWork save(ProfilePreviousWork profilePreviousWork);
    Boolean delete(Long id);
    Boolean delete(ProfilePreviousWork profilePreviousWork);
    ProfilePreviousWork update(ProfilePreviousWork profilePreviousWork);
}

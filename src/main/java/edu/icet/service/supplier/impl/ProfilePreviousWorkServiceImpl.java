package edu.icet.service.supplier.impl;

import edu.icet.dto.Profile;
import edu.icet.dto.ProfilePreviousWork;
import edu.icet.service.supplier.ProfilePreviousWorkService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfilePreviousWorkServiceImpl implements ProfilePreviousWorkService {
    @Override
    public List<ProfilePreviousWork> getAll(Profile profile) {
        return List.of();
    }

    @Override
    public ProfilePreviousWork save(ProfilePreviousWork profilePreviousWork) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public ProfilePreviousWork search(String query) {
        return null;
    }

    @Override
    public Boolean delete(ProfilePreviousWork profilePreviousWork) {
        return null;
    }

    @Override
    public ProfilePreviousWork update(ProfilePreviousWork profilePreviousWork) {
        return null;
    }
}

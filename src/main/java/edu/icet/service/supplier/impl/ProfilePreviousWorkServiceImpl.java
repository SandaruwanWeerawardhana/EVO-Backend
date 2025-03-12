package edu.icet.service.supplier.impl;

import edu.icet.dto.Profile;
import edu.icet.dto.ProfilePreviousWork;
import edu.icet.service.supplier.ProfilePreviousWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProfilePreviousWorkServiceImpl implements ProfilePreviousWorkService {
    private final List<ProfilePreviousWork> profilePreviousWorkList = new ArrayList<>();

    @Override
    public List<ProfilePreviousWork> getAll(Profile profile) {
        for (ProfilePreviousWork Work : profilePreviousWorkList) {
            if (Work.getProfileID().equals(profile.getId())) {
                profilePreviousWorkList.add(Work);
            }
        }
        return profilePreviousWorkList;
    }

    @Override
    public boolean save(ProfilePreviousWork profilePreviousWork) {
        return profilePreviousWorkList.add(profilePreviousWork);
    }

    @Override
    public Boolean delete(Long id) {
        for (ProfilePreviousWork Work : profilePreviousWorkList) {
            if (Work.getProfileID().equals(id)) {
                profilePreviousWorkList.remove(Work);
                return true;
            }
        }
        return false;
    }

    @Override
    public ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork) {
        if (profilePreviousWork != null) {
            if (profilePreviousWork.getPreviousWorkID() != null) {
                return searchByPreviousWorkID(profilePreviousWork.getPreviousWorkID());
            } else if (profilePreviousWork.getProfileID() != null) {
                return searchByProfileID(profilePreviousWork.getProfileID());
            }
        }
        return null;
    }

    private ProfilePreviousWork searchByPreviousWorkID(Long previousWorkID) {
        for (ProfilePreviousWork work : profilePreviousWorkList) {
            if (work.getPreviousWorkID().equals(previousWorkID)) {
                return work;
            }
        }
        return null;
    }

    private ProfilePreviousWork searchByProfileID(Long profileID) {
        for (ProfilePreviousWork work : profilePreviousWorkList) {
            if (work.getProfileID().equals(profileID)) {
                return work;
            }
        }
        return null;
    }


    @Override
    public boolean update(ProfilePreviousWork profilePreviousWork) {
        for (ProfilePreviousWork Work : profilePreviousWorkList) {
            if (Work.getPreviousWorkID().equals(profilePreviousWork.getPreviousWorkID())) {
                profilePreviousWorkList.set(profilePreviousWorkList.indexOf(Work), profilePreviousWork);
                return true;
            }
        }
        return false;
    }
}

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
            if (Work.getProfileId().equals(profile.getId())) {
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
            if (Work.getProfileId().equals(id)) {
                profilePreviousWorkList.remove(Work);
                return true;
            }
        }
        return false;
    }

    @Override
    public ProfilePreviousWork search(ProfilePreviousWork profilePreviousWork) {
        if (profilePreviousWork!=null) {
            if (profilePreviousWork.getWorkId()!=null) {
                search(profilePreviousWork.getWorkId());
            }else if (profilePreviousWork.getProfileId()!=null) {
                search(profilePreviousWork.getProfileId());
            } else if (profilePreviousWork.getTitle()!=null) {
                search(profilePreviousWork.getTitle());
            } else if (profilePreviousWork.getClientName()!=null) {
                search(profilePreviousWork.getClientName());
            }
        }
        return null;
    }

    private ProfilePreviousWork search(String s) {
        for (ProfilePreviousWork Work : profilePreviousWorkList) {
            if (Work.getTitle().equals(s)) {
                return Work;
            } else if (Work.getClientName().equals(s)) return Work;
        }
        return null;
    }

    private ProfilePreviousWork search(Long id) {
        for (ProfilePreviousWork work : profilePreviousWorkList) {
            if (work.getWorkId().equals(id)) {
                return work;
            } else if (work.getProfileId().equals(id)) return work;
        }
        return null;
    }

    @Override
    public boolean update(ProfilePreviousWork profilePreviousWork) {
        for (ProfilePreviousWork Work : profilePreviousWorkList) {
            if (Work.getWorkId().equals(profilePreviousWork.getWorkId())) {
                profilePreviousWorkList.set(profilePreviousWorkList.indexOf(Work), profilePreviousWork);
                return true;
            }
        }
        return false;
    }
}

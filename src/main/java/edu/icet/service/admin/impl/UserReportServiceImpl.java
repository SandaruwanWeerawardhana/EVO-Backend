package edu.icet.service.admin.impl;

import edu.icet.dto.UserReport;
import edu.icet.service.admin.UserReportService;
import edu.icet.util.UserType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserReportServiceImpl implements UserReportService {
    @Override
    public boolean saveUserReport(UserReport userReport) {
        return false;
    }

    @Override
    public UserReport getUserReportById(Long id) {
        return null;
    }

    @Override
    public List<UserReport> getAllUserReports() {
        return List.of();
    }

    @Override
    public boolean updateUserReport(Long id, UserReport userReport) {
        return false;
    }

    @Override
    public boolean deleteUserReport(Long id) {
        return false;
    }

    @Override
    public List<UserReport> findByName(String name) {
        return List.of();
    }

    @Override
    public List<UserReport> findByUserType(UserType userType) {
        return List.of();
    }

    @Override
    public boolean deleteUserReportById(Long id) {
        return false;
    }
}

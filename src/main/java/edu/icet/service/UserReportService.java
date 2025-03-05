package edu.icet.service;

import edu.icet.dto.UserReport;
import edu.icet.util.UserType;

import java.util.List;

public interface UserReportService {
    boolean saveUserReport(UserReport userReport);
    UserReport getUserReportById(Long id);
    List<UserReport> getAllUserReports();
    boolean updateUserReport(Long id, UserReport userReport);
    boolean deleteUserReport(Long id);
    List<UserReport> findByName(String name);
    List<UserReport> findByUserType(UserType userType);
    boolean deleteUserReportById(Long id);
}

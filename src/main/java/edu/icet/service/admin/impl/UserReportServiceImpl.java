package edu.icet.service.admin.impl;

import edu.icet.dto.UserReport;
import edu.icet.service.admin.UserReportService;
import edu.icet.util.UserType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserReportServiceImpl implements UserReportService {
    List<UserReport> userReportServices =new ArrayList<>();

    @Override
    public boolean saveUserReport(UserReport userReport) {
        return userReportServices.add(userReport);
    }

    @Override
    public UserReport getUserReportById(Long id) {
        for (UserReport userReport:userReportServices){
            if (userReport.getId().equals(id)){
                return userReport;
            }

        }
        return null;
    }

    @Override
    public List<UserReport> getAllUserReports() {
        return  userReportServices;
    }

    @Override
    public boolean updateUserReport(Long id, UserReport userReport) {
        for (int i = 0; i < userReportServices.size(); i++) {
            if (userReportServices.get(i).getId().equals(id)) {
                userReportServices.set(i, userReport);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUserReport(Long id) {
        return userReportServices.removeIf(userReport -> Objects.equals(userReport.getId(),id));
    }

    @Override
    public List<UserReport> findByName(String name) {
        return userReportServices.stream().filter(userReport -> userReport.getName().equals(name)).toList();
    }

    @Override
    public List<UserReport> findByUserType(UserType userType) {
        return userReportServices.stream().filter(userReport -> userReport.getUsertype().equals(userReport)).toList();
    }

    @Override
    public boolean deleteUserReportById(Long id) {
        return userReportServices.removeIf(userReport -> Objects.equals(userReport.getId(),id));
    }
}

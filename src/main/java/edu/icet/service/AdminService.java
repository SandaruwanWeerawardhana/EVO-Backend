package edu.icet.service;
import edu.icet.dto.Admin;
import edu.icet.util.AdminType;

import java.util.List;
public interface AdminService {
     boolean addAdmin (Admin admin);
     boolean deleteAdmin (Integer adminID);
     boolean updateAdmin(Integer adminID,Admin admin);
     Admin getAdminById(Integer adminID);
     boolean adminExists(Integer adminID);
     int countAdmins();
     boolean changeAdminType(AdminType type);
     List<Admin>getAllAdmins();
     List<Admin>getAdminByType(String type);
}

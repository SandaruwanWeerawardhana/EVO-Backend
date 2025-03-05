package edu.icet.service;
import edu.icet.dto.Admin;

import java.util.List;
public interface AdminService {
     boolean addAdmin (Admin admin);
     boolean deleteAdmin (Integer adminID);
     boolean updateAdmin(Integer adminID,Admin admin);
     Admin getAdminById(Integer adminID);
     boolean adminExists(Integer adminID);
     Integer countAdmins();
     List<Admin>getAllAdmins();
     List<Admin>getAdminByType(AdminType type);
}

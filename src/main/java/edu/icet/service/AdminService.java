package edu.icet.service;
import edu.icet.dto.Admin;
import java.util.List;
public interface AdminService {
     boolean addAdmin (Admin admin);
     boolean deleteAdmin (Integer adminID);
     boolean updateAdmin(Admin admin);
     Admin getAdminById(Integer adminId);
     boolean isAdminType(Integer adminId,String type);
     boolean adminExists(Integer adminId);
     int countAdmins();
     boolean changeAdminType(String type);
     List<Admin>getAllAdmins();
     List<Admin>getAdminByType(String type);
}

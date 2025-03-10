package edu.icet.service.admin;
import edu.icet.dto.Admin;
import edu.icet.util.AdminType;
import org.springframework.stereotype.Service;

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

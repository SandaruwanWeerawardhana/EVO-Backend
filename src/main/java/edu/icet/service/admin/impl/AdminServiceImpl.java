package edu.icet.service.admin.impl;

import edu.icet.dto.Admin;
import edu.icet.service.admin.AdminService;
import edu.icet.util.AdminType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Primary
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ArrayList<Admin> adminRepository = new ArrayList<>();
    private final ModelMapper modelMapper;

    @Override
    public boolean addAdmin(Admin admin) {
        return adminRepository.add(admin);

    }

    @Override
    public boolean deleteAdmin(Integer adminID) {
        return adminRepository.removeIf(admin -> Objects.equals(admin.getAdminId(), adminID));


    }

    @Override
    public boolean updateAdmin(Integer adminID, Admin admin) {

        for (int i = 0; i < adminRepository.size(); i++) {
            if (adminRepository.get(i).getAdminId().equals(adminID)) {
                adminRepository.set(i, admin);
                return true;
            }
        }
        return false;

    }

    @Override
    public Admin getAdminById(Integer adminID) {
        for (Admin admin : adminRepository) {
            if (admin.getAdminId().equals(adminID)) {
                return admin;
            }
        }
        return null;

    }

    @Override
    public boolean adminExists(Integer adminID) {
        for (Admin admin : adminRepository) {
            if (admin.getAdminId().equals(adminID)) return true;
        }
        return false;
    }
    @Override
    public Integer countAdmins() {
      return adminRepository.size();
    }


    public boolean changeAdminType(Integer adminID, AdminType type) {
        for (Admin admin : adminRepository) {
            if (admin.getAdminId().equals(adminID)) {
                admin.setType(type);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository;
    }

    @Override
    public List<Admin> getAdminByType(AdminType type) {
        ArrayList<Admin> typeArrayList=new ArrayList<>();
        adminRepository.forEach(admin ->{
           if (admin.getType().equals(type)) typeArrayList.add(admin);
        });
        return typeArrayList;
    }
}



package edu.icet.service.admin.impl;

import edu.icet.dto.Admin;
import edu.icet.entity.AdminEntity;
import edu.icet.repository.AdminRepository;
import edu.icet.service.admin.AdminService;
import edu.icet.util.AdminType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;
    private final ModelMapper mapper;

    @Override
    public boolean addAdmin(Admin admin) {
        AdminEntity save = repo.save(mapper.map(admin, AdminEntity.class));
        if (save != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(Long adminID) {
        if (repo.existsById(adminID)){
            repo.deleteById(adminID);
            return true;
        }
        return false;


    }

    @Override
    public boolean updateAdmin(Long adminID, Admin admin) {
        if (repo.existsById(adminID)) {
            AdminEntity save = repo.save(mapper.map(admin, AdminEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public Admin getAdminById(Long adminID) {
       return mapper.map(repo.findById(adminID), Admin.class);
    }


    @Override
    public boolean adminExists(Long adminID) {
       return repo.existsById(adminID);
    }
    @Override
    public Long countAdmins() {
      return repo.count();
    }


    public boolean changeAdminType(Long adminID, AdminType type) {
        return repo.findById(adminID).map(adminEntity -> {
             adminEntity.setType(type);
             repo.save(adminEntity);
             return true;
         }).orElse (false);
    }

    @Override
    public List<Admin> getAllAdmins() {
        List<AdminEntity> all = repo.findAll();
        List<Admin> adminList=new ArrayList<>();
        all.forEach(admin ->{
           adminList.add(mapper.map(admin,Admin.class));
        });
        return adminList;
    }

    @Override
    public List<Admin> getAdminByType(AdminType type) {
        List<Admin> adminList=new ArrayList<>();
       repo.findAllByType(type).forEach(admin -> {
           adminList.add(mapper.map(admin,Admin.class));
        });
        return adminList;
    }
}



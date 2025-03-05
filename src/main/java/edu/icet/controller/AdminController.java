package edu.icet.controller;

import edu.icet.dto.Admin;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
        boolean addAdmin = adminService.addAdmin(admin);
        if (addAdmin){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Integer adminId){
       boolean deleteAdmin = adminService.deleteAdmin(adminId);
       if (deleteAdmin) {
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
           
    }
    
    @PutMapping("/update/{adminId}")
    public ResponseEntity<String> updateAdmin(@PathVariable Integer adminId,@RequestBody Admin admin){
        boolean updateAdmin = adminService.updateAdmin(adminId, admin);
        if (updateAdmin){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId){
       Admin admin = adminService.getAdminById(adminId);
       if (getAdmin){
           return new ResponseEntity<>(admin,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/exists/{adminId}")
    public ResponseEntity<String> adminExits(@PathVariable Integer adminId){
        boolean existsAdmin = adminService.adminExists(adminId);
        if (existsAdmin) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countAdmins() {
        Integer adminCount = adminService.countAdmins();
        if (adminCount) {
            return new ResponseEntity<>(adminCount,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     @GetMapping("/all")
        public  ResponseEntity<List<Admin>> getAllAdmins(){
        List<Admin> allAdmins = adminService.getAllAdmins();
        if (allAdmins !=null){
            return new ResponseEntity<>(allAdmins, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/type/{type}")
    public  ResponseEntity<List<Admin>>getAdminByType(){
       List<Admin> AdminsByType = adminService.getAdminByType();
       if (AdminByType != null){
           return new ResponseEntity<>(AdminsByType,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

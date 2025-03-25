package edu.icet.controller.admin;

import edu.icet.dto.admin.Admin;
import edu.icet.service.admin.AdminService;
import edu.icet.util.AdminType;
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
    public ResponseEntity<String> deleteAdmin(@PathVariable Long adminId){
       boolean deleteAdmin = adminService.deleteAdmin(adminId);
       if (deleteAdmin) {
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
           
    }
    
    @PutMapping("/update/{adminId}")
    public ResponseEntity<String> updateAdmin(@PathVariable Long adminId,@RequestBody Admin admin){
        boolean updateAdmin = adminService.updateAdmin(adminId, admin);
        if (updateAdmin){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long adminId){
       Admin admin = adminService.getAdminById(adminId);
       if (admin!=null){
           return new ResponseEntity<>(admin,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/exists/{adminId}")
    public ResponseEntity<String> adminExits(@PathVariable Long adminId){
        boolean existsAdmin = adminService.adminExists(adminId);
        if (existsAdmin) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAdmins() {
        Long adminCount = adminService.countAdmins();
        if (adminCount>0) {
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

    @GetMapping("/get-type/{type}")
    public ResponseEntity<List<Admin>> getAdminByType(@PathVariable("type") String type) {
        List<Admin> adminsByType = adminService.getAdminByType(AdminType.valueOf(type));
        if (adminsByType != null && !adminsByType.isEmpty()) {
            return new ResponseEntity<>(adminsByType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

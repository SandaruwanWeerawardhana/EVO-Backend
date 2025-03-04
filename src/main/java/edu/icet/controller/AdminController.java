package edu.icet.controller;

import edu.icet.dto.Admin;
import edu.icet.service.AdminService;
import edu.icet.util.AdminType;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Boolean> addAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.addAdmin(admin));
    }

    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<Boolean>deleteAdmin(@PathVariable Integer adminId){
        return  ResponseEntity.ok(adminService.deleteAdmin(adminId));
    }

    @PutMapping("/update/{adminId}")
    public ResponseEntity<Boolean>updateAdmin(@PathVariable Integer adminId,@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.updateAdmin(adminId,admin));
    }

    @GetMapping("/get/{adminId}")
    public ResponseEntity<Admin>getAdminById(@PathVariable Integer adminId){
        return ResponseEntity.ok(adminService.getAdminById(adminId));
    }

    @GetMapping("/exists/{adminId}")
    public ResponseEntity<Boolean>adminExits(@PathVariable Integer adminId){
        return ResponseEntity.ok(adminService.adminExists(adminId));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> countAdmins() {
        return ResponseEntity.ok(adminService.countAdmins());
    }

    @PatchMapping("/changeType")
    public ResponseEntity<Boolean>changeAdminType(@RequestParam AdminType type){
        return  ResponseEntity.ok(adminService.changeAdminType(type));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<Admin>>getAllAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/type/{type}")
    public  ResponseEntity<List<Admin>>getAdminByType(@PathVariable String type){
        return  ResponseEntity.ok(adminService.getAdminByType(type));
    }
}

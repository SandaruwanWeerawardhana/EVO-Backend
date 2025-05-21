package edu.icet.controller.auth;

import edu.icet.dto.admin.Admin;
import edu.icet.dto.auth.JwtResponse;
import edu.icet.dto.auth.LoginRequest;
import edu.icet.dto.customer.Customer;
import edu.icet.dto.supplier.Supplier;
import edu.icet.security.JwtUtil;
import edu.icet.service.admin.AdminService;
import edu.icet.service.customer.CustomerService;
import edu.icet.service.supplier.SupplierManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomerService customerService;
    private final SupplierManager supplierService;
    private final AdminService adminService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register-customer")
    public ResponseEntity<?> registerCustomer(@Valid @RequestBody Customer customer) {
        if (customerService.existsByEmail(customer.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully");
    }

    @PostMapping("/register-admin")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody Admin admin) {
        if (customerService.existsByEmail(admin.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        adminService.addAdmin(admin);
        return ResponseEntity.ok("Admin registered successfully");
    }

    @PostMapping("/register-supplier")
    public ResponseEntity<?> registerSupplier(@Valid @RequestBody Supplier supplier) {
        if (supplierService.existsByEmail(supplier.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        supplierService.addSupplier(supplier);
        return ResponseEntity.ok("Supplier registered successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        final String role;
        final Object entity;
        final String email = loginRequest.getEmail();

        if (this.customerService.isCustomerExist(email)) {
            role = "CUSTOMER";
            entity = this.customerService.getCustomerByEmail(email);
        } else if (this.supplierService.existsByEmail(email)) {
            role = "SUPPLIER";
            entity = this.supplierService.getCustomerByEmail(email);
        } else if (this.adminService.existsByEmail(email)) {
            role = "ADMIN";
            entity = this.adminService.getCustomerByEmail(email);
        } else {
            role = null;
            entity = null;
        }

        if (role == null) return ResponseEntity.badRequest().build();

        UserDetails userDetails = customerService.loadUserByUsername(loginRequest.getEmail());
        String jwtToken = jwtUtil.generateToken(userDetails, role);

        return ResponseEntity.ok(new JwtResponse(loginRequest.getEmail(), jwtToken, entity));
    }
}

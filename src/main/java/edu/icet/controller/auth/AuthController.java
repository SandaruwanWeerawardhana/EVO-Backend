package edu.icet.controller.auth;

import edu.icet.dto.auth.JwtResponse;
import edu.icet.dto.auth.LoginRequest;
import edu.icet.dto.customer.Customer;
import edu.icet.security.JwtUtil;
import edu.icet.service.admin.AdminService;
import edu.icet.service.customer.CustomerService;
import edu.icet.service.supplier.SupplierService;
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
    private final SupplierService supplierService;
    private final AdminService adminService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Customer customer) {
        if (customerService.existsByEmail(customer.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        customerService.addCustomer(customer);
        return ResponseEntity.ok("Customer registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid email or password");
        }

        if (this.customerService.getCus)
        final String userRole = "CUSTOMER";

        UserDetails userDetails = customerService.loadUserByUsername(loginRequest.getEmail());
        String jwtToken = jwtUtil.generateToken(userDetails, userRole);

        return ResponseEntity.ok(new JwtResponse(loginRequest.getEmail(), jwtToken));
    }
}

package edu.icet.security;

import edu.icet.dto.customer.Customer;
import edu.icet.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = modelMapper.map(customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found")), Customer.class);

        return User
                .withUsername(customer.getEmail())
                .password(customer.getPassword())
                .roles("CUSTOMER")
                .build();
    }
}

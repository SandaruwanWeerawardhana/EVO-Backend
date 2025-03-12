package edu.icet.service.customer.impl;

import edu.icet.dto.Customer;
import edu.icet.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final List<Customer> customerRepository = new ArrayList<>();

    @Override
    public boolean addCustomer(Customer customer) {
        return customerRepository.add(customer);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerRepository.removeIf(customer -> Objects.equals(customer.getId(), id));
    }

    @Override
    public boolean updateCustomer(Long id, Customer customer) {
        for (int i = 0; i < customerRepository.size(); i++) {
            if (Objects.equals(customerRepository.get(i).getId(), id)) {
                customerRepository.set(i, customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.stream()
                .filter(customer -> Objects.equals(customer.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerRepository);
    }
}

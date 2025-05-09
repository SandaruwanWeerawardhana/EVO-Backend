package edu.icet.service.customer.impl;

import edu.icet.dto.customer.Customer;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.repository.customer.CustomerRepository;
import edu.icet.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    final CustomerRepository customerRepository;
    final ModelMapper modelMapper;

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            log.info("customer is null");
            return false;
        }

        Optional<CustomerEntity> existingCustomer = customerRepository.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            log.warn("Customer with email {} already exists", customer.getEmail());
            return false;
        }

        CustomerEntity savedEntity = customerRepository.save(modelMapper.map(customer, CustomerEntity.class));
        return savedEntity.getContactNumber().equals(customer.getContactNumber());
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (id == null) {
            log.info("id is null");
            return false;
        }
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCustomer(Long id, Customer customer) {
        if (id == null || customer == null) {
            log.info("id or customer is null");
            return false;
        }
        if (!customerRepository.existsById(id)) {
            log.info("Customer with id {} does not exist", id);
            return false;
        }
        if (!id.equals(customer.getId())) {
            log.info("Customer ID in request body does not match the path variable");
            return false;
        }
        CustomerEntity updatedEntity = customerRepository.save(modelMapper.map(customer, CustomerEntity.class));
        return updatedEntity.getId().equals(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        if (id == null) {
            log.info("customerId is null");
            return null;
        }
        if (!customerRepository.existsById(id)) {
            log.info("Customer  with id {} does not exist", id);
            return null;
        }
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> modelMapper.map(entity, Customer.class)).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(entity -> customers.add(modelMapper.map(entity, Customer.class)));
        return customers;
    }
}

package edu.icet.service.customer.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;
    final ModelMapper modelMapper;

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        CustomerEntity savedEntity = customerRepository.save(modelMapper.map(customer, CustomerEntity.class));
        return savedEntity.getContactNumber().equals(customer.getContactNumber()) && savedEntity.getName().equals(customer.getName());
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (id == null) {
            return false;
        }
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCustomer(Long id, Customer customer) {
        if (id == null || customer == null) {
            return false;
        }
        if (!customerRepository.existsById(id)) {
            return false;
        }
        if (!id.equals(customer.getId())) {
            return false;
        }
        CustomerEntity updatedEntity = customerRepository.save(modelMapper.map(customer, CustomerEntity.class));
        return updatedEntity.getId().equals(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        if (id == null) {
            return null;
        }
        if (!customerRepository.existsById(id)) {
            return null;
        }
        return modelMapper.map(customerRepository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(entity -> customers.add(modelMapper.map(entity, Customer.class)));
        return customers;
    }
}

package edu.icet.service.customer;

import edu.icet.dto.Admin;
import edu.icet.dto.Customer;
import edu.icet.util.AdminType;

import java.util.List;

public interface CustomerService {
    boolean addCustomer (Customer customer);
    boolean deleteCustomer (Long id);
    boolean updateCustomer(Long id,Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();

}

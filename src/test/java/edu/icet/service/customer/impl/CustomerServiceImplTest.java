package edu.icet.service.customer.impl;

import edu.icet.dto.customer.Customer;
import edu.icet.entity.customer.CustomerEntity;
import edu.icet.repository.customer.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock(lenient = true)
    private ModelMapper modelMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer1, customer2;
    private CustomerEntity customerEntity1, customerEntity2;

    @BeforeEach
    void setup() {
        customer1 = new Customer(1L, "pasidu", "binush", "pasidbinush@gmail.com", "Pasi@123", "0712345678");
        customer2 = new Customer(2L, "ruwan", "dilhara", "ruwandilhara@gmail.com", "Ruwan@123", "0712345678");

        customerEntity1 = new CustomerEntity(1L, "pasidu", "binush", "pasidbinush@gmail.com", "Pasi@123", "0712345678");
        customerEntity2 = new CustomerEntity(2L, "ruwan", "dilhara", "ruwandilhara@gmail.com", "Ruwan@123", "0712345678");
    }

    @Test
    void addCustomer_Success() {
        when(customerRepository.findByEmail(customer1.getEmail())).thenReturn(Optional.empty());
        when(modelMapper.map(customer1, CustomerEntity.class)).thenReturn(customerEntity1);
        when(customerRepository.save(customerEntity1)).thenReturn(customerEntity1);

        boolean result = customerService.addCustomer(customer1);

        assertTrue(result);
        verify(customerRepository, times(1)).save(customerEntity1);
    }

    @Test
    void addCustomer_AlreadyExists() {
        when(customerRepository.findByEmail(customer1.getEmail())).thenReturn(Optional.of(customerEntity1));

        boolean result = customerService.addCustomer(customer1);

        assertFalse(result);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void addCustomer_NullCustomer() {
        assertFalse(customerService.addCustomer(null));
        verify(customerRepository, never()).save(any());
    }

    @Test
    void deleteCustomer_Success() {
        assertTrue(customerService.deleteCustomer(1L));
        verify(customerRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteCustomer_NullId() {
        assertFalse(customerService.deleteCustomer(null));
        verify(customerRepository, never()).deleteById(any());
    }

    @Test
    void updateCustomer_Success() {
        customer1.setFirstName("Updated Name");

        when(customerRepository.existsById(1L)).thenReturn(true);
        when(modelMapper.map(customer1, CustomerEntity.class)).thenReturn(customerEntity1);
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity1);

        boolean result = customerService.updateCustomer(1L, customer1);

        assertTrue(result);
        verify(customerRepository, times(1)).save(any(CustomerEntity.class));
    }

    @Test
    void updateCustomer_CustomerDoesNotExist() {
        when(customerRepository.existsById(1L)).thenReturn(false);

        boolean result = customerService.updateCustomer(1L, customer1);

        assertFalse(result);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void updateCustomer_IdMismatch() {
        customer1.setId(2L);

        when(customerRepository.existsById(1L)).thenReturn(true);

        boolean result = customerService.updateCustomer(1L, customer1);

        assertFalse(result);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void updateCustomer_NullInput() {
        assertFalse(customerService.updateCustomer(null, customer1));
        assertFalse(customerService.updateCustomer(1L, null));
    }

    @Test
    void getCustomerById_NullId() {
        assertNull(customerService.getCustomerById(null));
        verify(customerRepository, never()).findById(any());
    }

    @Test
    void getCustomerById_CustomerDoesNotExist() {
        when(customerRepository.existsById(customer2.getId())).thenReturn(false);

        Customer result = customerService.getCustomerById(customer2.getId());

        assertNull(result);
        verify(customerRepository, times(1)).existsById(customer2.getId());
        verify(modelMapper, never()).map(any(), eq(Customer.class));
    }

    @Test
    void getCustomerById_Success() {
        when(customerRepository.existsById(1L)).thenReturn(true);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity1));
        when(modelMapper.map(customerEntity1, Customer.class)).thenReturn(customer1);

        Customer result = customerService.getCustomerById(customer1.getId());

        assertNotNull(result);
        assertEquals(customer1.getFirstName(), result.getFirstName());
        verify(customerRepository, times(1)).existsById(customer1.getId());
        verify(customerRepository, times(1)).findById(customer1.getId());
        verify(modelMapper, times(1)).map(customerEntity1, Customer.class);
    }

    @Test
    void getAllCustomers_Success() {
        when(customerRepository.findAll()).thenReturn(List.of(customerEntity1, customerEntity2));
        when(modelMapper.map(customerEntity1, Customer.class)).thenReturn(customer1);
        when(modelMapper.map(customerEntity2, Customer.class)).thenReturn(customer2);

        List<Customer> result = customerService.getAllCustomers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void getAllCustomers_EmptyList() {
        when(customerRepository.findAll()).thenReturn(List.of());

        List<Customer> result = customerService.getAllCustomers();

        assertNotNull(result);
        assertEquals(0, result.size());
        verify(customerRepository, times(1)).findAll();
    }
}

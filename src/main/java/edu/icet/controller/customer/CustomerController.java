package edu.icet.controller.customer;

import edu.icet.dto.customer.Customer;
import edu.icet.dto.event.EventSummary;
import edu.icet.service.customer.CustomerService;
import edu.icet.service.system.EventSummaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final EventSummaryService eventSummaryService;

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Customer customer) {
        boolean isAdded = customerService.addCustomer(customer);
        return isAdded ? ResponseEntity.status(HttpStatus.CREATED).body("Customer added successfully.") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add customer.");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable @Valid Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(customers);
    }

    @GetMapping("/get-all-event-summaries/{id}")
    public ResponseEntity<List<EventSummary>> getAllEventSummaries(@PathVariable @Valid Long id) {
        List<EventSummary> eventSummaryList = eventSummaryService.getEventSummariesByCustomerId(id);
        return eventSummaryList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(eventSummaryList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable @Valid Long id, @RequestBody @Valid Customer customer) {
        boolean isUpdated = customerService.updateCustomer(id, customer);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body("Customer updated successfully.") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable @Valid Long id) {
        boolean isDeleted = customerService.deleteCustomer(id);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully.") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
    }
}

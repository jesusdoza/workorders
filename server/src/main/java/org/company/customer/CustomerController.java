package org.company.customer;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

    @PostMapping("")
    public Customer createCustomer(@RequestBody CustomerPostRequest customerPostRequest) {
        Customer newCustomer = new Customer(customerPostRequest.name(), customerPostRequest.company(), customerPostRequest.contactInfo());

        return customerRepository.save(newCustomer);

    }

}

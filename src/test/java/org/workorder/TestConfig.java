package org.workorder;


import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.context.annotation.*;

import org.workorder.customer.Customer;
import org.workorder.customer.CustomerRepository;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig {

//    @MockBean
//    private CustomerRepository customerRepository;
//
//
//
//    @Bean
//    @Primary
//    public CustomerRepository customerRepository() {
//        List<Customer> customers = List.of(new Customer(1L, "John Doe", "Acme Inc."));
//        CustomerRepository mockCustomerRepository = Mockito.mock(CustomerRepository.class);
//
//       BDDMockito.given(mockCustomerRepository.findAll()).willReturn(customers);
//
//        return mockCustomerRepository;
//    }



}
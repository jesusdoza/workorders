package org.example;

import org.example.customer.Customer;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import org.example.customer.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    @Primary
    public CustomerRepository database() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    @Primary
    public Customer customerEntity() {
        return Mockito.mock(Customer.class);
    }
}
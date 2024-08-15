package org.company;


import org.company.customer.CustomerRepository;
import org.company.workorder.WorkorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    WorkorderRepository workorderRepository;
    @Autowired
    CustomerRepository customerRepository;


}
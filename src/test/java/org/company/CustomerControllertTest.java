package org.company;

import org.company.customer.Customer;
import org.company.customer.CustomerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
//@ActiveProfiles("test")
//@Sql({"/customertable.sql"})
class CustomerControllertTest {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnCustomersListAll() throws Exception {
        List<Customer> list = List.of(
                new Customer(1L, "John Doe", "Acme Inc."),
                new Customer(2L, "Jane Smith", "Beta LLC"),
                new Customer(3L, "Jane Smith", "Beta LLC")
        );

        customerRepository.saveAll(list);


        var response = this.mvc.perform(get("/customer"));


        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(list.size())));


    }
}

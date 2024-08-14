package org.example;

import org.example.customer.Customer;
import org.example.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CustomerControllertTest {


    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnCustomersList() throws Exception {
        List<Customer> customers = List.of(new Customer(1L, "John Doe", "Acme Inc."));
        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        this.mvc.perform(get("/customer"))
                .andExpect(status().isOk());




    }
}

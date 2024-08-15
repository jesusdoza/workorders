package org.company;

import org.company.customer.Customer;
import org.company.customer.CustomerRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CustomerControllertTest {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnCustomersListAll() throws Exception {
        List<Customer> customers = List.of(
                new Customer(1L, "John Doe", "Acme Inc."),
                new Customer(2L, "Jane Smith", "Beta LLC")
        );

        customerRepository.saveAll(customers);


        //FIXTHIS BACK
//        List<Customer> customers = List.of(new Customer(1L, "John Doe", "Acme Inc."));
//        Mockito.when(customerRepository.findAll()).thenReturn(customers);

//        var response = this.mvc.perform(get("/customer"))
//                .andExpect(status().isOk());
//        var cont = response.andReturn().getResponse().getContentAsString();

        //FIXTHIS BACK

        this.mvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(customers.size())));


    }
}

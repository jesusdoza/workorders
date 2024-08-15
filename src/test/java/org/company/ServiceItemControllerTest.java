package org.company;


import org.company.service_item.ServiceItem;
import org.company.service_item.ServiceItemRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
public class ServiceItemControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ServiceItemRepository repository;

    @Test
    void getAllServiceitems() throws Exception {
        List<ServiceItem> items = List.of(new ServiceItem("ddec4", "123432"), new ServiceItem("cummins", "21sdwdfwd"));

        this.repository.saveAll(items);

        var response = this.mvc.perform(get("/service_item"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(items.size())));

    }
}

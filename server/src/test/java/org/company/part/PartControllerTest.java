package org.company.part;

import org.company.WorkOrdersApp;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class PartControllerTest {


    @Autowired
    private MockMvc mvc;
    @Autowired
    private PartRepository repository;


    @Test
    void shouldReturnPartsListAll() throws Exception {

        List<Part> items = List.of(
                new Part("hot chip"),
                new Part("resistor"),
                new Part("resistor")
        );
        this.repository.saveAll(items);


        var response = this.mvc.perform(get("/api/part").with(jwt()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(items.size()))).andDo(print());


    }
}

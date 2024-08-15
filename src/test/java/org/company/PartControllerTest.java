package org.company;

import org.company.part.Part;
import org.company.part.PartRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
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


        var response = this.mvc.perform(get("/part"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(items.size())));


    }
}

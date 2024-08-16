package org.company;


import org.company.part.Part;
import org.company.technician.Technician;
import org.company.technician.TechnicianRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class TechnicianControllerTest {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private TechnicianRepository repository;


    @Test

    public void getAllTechnicians() throws Exception {
        List<Technician> items = List.of(
                new Technician("techname1"),
                new Technician("techname2"),
                new Technician("techname3")
        );
        this.repository.saveAll(items);


        var response = this.mvc.perform(get("/tech"));

        System.out.println(response.andReturn().getRequest());

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }
}

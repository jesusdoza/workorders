package org.company.workorder;

import org.company.WorkOrdersApp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class WorkorderControllerTest {
//    @Autowired
//    private WorkorderRepository repository;


    @Autowired
    private MockMvc mvc;


    @Test
    void shouldReturnCustomersListAll() throws Exception {


//        List<Workorder> workorders = List.of(new Workorder("new workorder 1"), new Workorder("new work 2"));
//
//        repository.saveAll(workorders);
//
//        var response = this.mvc.perform(get("/workorders"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", Matchers.hasSize(workorders.size())));
//
//        System.out.println("response *****************************");
//        System.out.println(response);
    }
}

package org.company;

import org.company.workorder.Workorder;
import org.company.workorder.WorkorderRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

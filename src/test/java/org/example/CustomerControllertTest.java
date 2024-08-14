package example.customer;

import org.example.WorkOrdersApp;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = WorkOrdersApp.class)
@AutoConfigureMockMvc
class CustomerControllertTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturnCutomersList() throws Exception {
        var response  =get("/customer");
        this.mvc.perform(response)
                .andExpect(status().isOk());

        System.out.println(response);
    }
}

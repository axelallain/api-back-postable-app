package fr.axelallain.raspapijava.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.axelallain.raspapijava.model.Rent;
import fr.axelallain.raspapijava.service.RentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RestController.class)
public class RentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ObjectMapper objectMapper;

    @MockBean
    private RentService rentService;

    @Test
    void contextLoads() {
    }

    /*

    @Test
    public void findAllByUsernameAndStatus_shouldReturnExpiredRentsOnly_whenParametersStatusIsExpired() throws Exception {
        // GIVEN
        List<Rent> testRents = new ArrayList<>();
        Rent rent1 = new Rent(1, "Axel Allain", "ongoing");
        Rent rent2 = new Rent(2, "Axel Allain", "expired");
        testRents.add(rent1);
        testRents.add(rent2);
        when(rentService.findAllByUsernameAndStatus("Axel Allain", "expired")).thenReturn(testRents);

        // WHEN
        ResultActions result = mockMvc.perform(
                get("/rents")
                        .param("username", "Axel Allain")
                        .param("status", "expired"))
                .andExpect(status().isOk());

        // MAPPING JSON TO POJO
        List<Rent> resultRents = objectMapper.readValue((JsonParser) result, new TypeReference<>(){});

        // THEN
        assertThat(resultRents.size()).isEqualTo(1);
        assertThat(resultRents.get(0).getStatus()).isEqualTo("expired");
    }

     */
}

package codes.neuralkatana.nkforum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturn400IfAuthDataIsIncorrect() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\n" +
                "    \"email\" : \"tester@nkforum.com\",\n" +
                "    \"password\" : \"99999\"\n" +
                "}";

        mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(400));
    }

    @Test
    void shouldReturn200IfAuthDataIsCorrect() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\n" +
                "    \"email\" : \"zeus@olympus.com\",\n" +
                "    \"password\" : \"123456\"\n" +
                "}";

        mvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200));
    }
}
package com.humblecoon.HumbleCoonBack;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.humblecoon.HumbleCoonBack.controllers.HelloController;
import com.humblecoon.HumbleCoonBack.entities.User;
import com.humblecoon.HumbleCoonBack.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void shouldReturnResponse() throws Exception {
        String queryString = "/hello?name=Test123";
        String postUrl = "/hello_json";

        String requestJson = "{\"name\": \"Test123\"}";
        String responseJson = "{\"id\":1, \"name\":\"Hello Test123!\"}";

        when(greetingService.greet("Test123")).thenReturn(new User(1L, "Hello Test123!"));

        mockMvc.perform(
                get(queryString))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));

        mockMvc.perform(
                post(postUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson));
    }
}

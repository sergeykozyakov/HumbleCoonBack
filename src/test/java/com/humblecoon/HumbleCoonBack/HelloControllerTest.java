package com.humblecoon.HumbleCoonBack;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.humblecoon.HumbleCoonBack.controllers.HelloController;
import com.humblecoon.HumbleCoonBack.entities.User;
import com.humblecoon.HumbleCoonBack.services.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService greetingService;

    @Test
    public void shouldReturnResponse() throws Exception {
        when(greetingService.greet("Test")).thenReturn(new User(1L, "Hello Test!"));

        mockMvc.perform(get("/hello?name=Test")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Test!")));
    }
}

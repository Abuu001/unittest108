package io.lugonzo.unittesting108.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sun.xml.bind.v2.model.impl.ModelBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        //Perforn GET
        RequestBuilder request = MockMvcRequestBuilders
                                    .get("/hello-world")
                                    .accept(MediaType.APPLICATION_JSON);

       MvcResult result = mockMvc.perform(request)
                                    .andExpect(status().isOk())
                                    .andExpect(content().string("hello world ##"))
                                    .andReturn();

       //verify
        assertEquals("hello world ##",result.getResponse().getContentAsString());
    }


}
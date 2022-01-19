package io.lugonzo.unittesting108.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStudent() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/stud")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"AEZAKMI\",\"name\":\"June\",\"age\":21,\"admissionNo\":98831}"))
                .andReturn();

    }


    @Test
    void jsonAssert() throws JSONException {
        String actual = "{\"id\":\"AEZAKMI\",\"name\":\"June\",\"age\":21,\"admissionNo\":98831}";
        String expected = "{\"id\":\"AEZAKMI\",\"name\":\"June\",\"age\":21,\"admissionNo\":98831}";

        JSONAssert.assertEquals(expected,actual,true);
    }
}
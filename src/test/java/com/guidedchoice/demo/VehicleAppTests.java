package com.guidedchoice.demo;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class VehicleAppTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleRepository vehicleRepository;

    @BeforeEach
    public void deleteAllBeforeTests() throws Exception {
            vehicleRepository.deleteAll();
    }

    @Test
    public void shouldReturnRepositoryIndex() throws Exception {
            mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                            jsonPath("$._links.vehicles").exists());
    }
    
    @Test
    public void shouldCreateEntity() throws Exception {
            mockMvc.perform(post("/vehicles").contentType("application/json")
            .content("{\"year\": 1995, \"make\":\"Honda\", \"model\":\"Civic\"}")).andExpect(status().isCreated());
    }


}

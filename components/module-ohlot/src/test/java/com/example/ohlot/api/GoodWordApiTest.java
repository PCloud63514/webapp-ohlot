package com.example.ohlot.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GoodWordApiTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new GoodWordApi()).build();
    }

    @Test
    void addGoodWord_createdHttpStatus() throws Exception {
        mockMvc.perform(post("/good-words"))
                .andExpect(status().isCreated());
    }

    @Test
    void updateGoodWord_okHttpStatus() throws Exception {
        mockMvc.perform(patch("/good-words"))
                .andExpect(status().isOk());
    }

    @Test
    void getGoodWord_okHttpStatus() throws Exception {
        mockMvc.perform(get("/good-words"))
                .andExpect(status().isOk());
    }
}
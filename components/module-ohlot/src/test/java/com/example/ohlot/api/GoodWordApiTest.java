package com.example.ohlot.api;

import com.example.ohlot.service.GoodWordAddResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GoodWordApiTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(new GoodWordApi()).build();
    }

    @Test
    void addGoodWord_createdHttpStatus() throws Exception {
        mockMvc.perform(post("/good-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    void addGoodWord_returnValue() throws Exception {

        mockMvc.perform(post("/good-words")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"content\":\"content1\" }"))
                .andExpect(jsonPath("$.id", equalTo("id")))
                .andExpect(jsonPath("$.content", equalTo("content1")))
                .andExpect(status().isCreated());
    }

    @Test
    void getGoodWord_okHttpStatus() throws Exception {
        mockMvc.perform(get("/good-words"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id", equalTo("id")))
                .andExpect(jsonPath("$[0].content", equalTo("content")))
                .andExpect(jsonPath("$[0].createAt", equalTo("2022-02-02 22:22:22")))
                .andExpect(jsonPath("$[0].updateAt", equalTo("2022-02-02 22:22:22")))
                .andExpect(status().isOk());
    }

    @Test
    void updateGoodWord_okHttpStatus() throws Exception {
        mockMvc.perform(patch("/good-words"))
                .andExpect(status().isOk());
    }
}
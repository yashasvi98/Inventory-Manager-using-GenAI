package com.example.inventory.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/items returns 200 and JSON array")
    void getAllItemsReturnsOk() throws Exception {
        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("POST /api/items with invalid body returns 400")
    void createItemWithInvalidBodyReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }

    // Add more edge case and error tests as needed
}

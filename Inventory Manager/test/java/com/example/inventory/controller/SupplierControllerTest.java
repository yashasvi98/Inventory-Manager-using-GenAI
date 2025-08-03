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
class SupplierControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/suppliers returns 200 and JSON array")
    void getAllSuppliersReturnsOk() throws Exception {
        mockMvc.perform(get("/api/suppliers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("POST /api/suppliers with invalid body returns 400")
    void createSupplierWithInvalidBodyReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/suppliers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }
}

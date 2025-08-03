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
class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/reservations returns 200 and JSON array")
    void getAllReservationsReturnsOk() throws Exception {
        mockMvc.perform(get("/api/reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("POST /api/reservations with invalid body returns 400")
    void createReservationWithInvalidBodyReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }
}

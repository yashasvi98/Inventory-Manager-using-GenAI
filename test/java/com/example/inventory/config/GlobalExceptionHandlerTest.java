package com.example.inventory.config;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleValidation_returnsBadRequestAndFieldErrors() {
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError error = new FieldError("obj", "field", "must not be null");
        when(bindingResult.getFieldErrors()).thenReturn(List.of(error));
        MethodArgumentNotValidException ex = mock(MethodArgumentNotValidException.class);
        when(ex.getBindingResult()).thenReturn(bindingResult);
        when(ex.getMessage()).thenReturn("Validation failed");
        when(ex.getParameter()).thenReturn(null);

        ResponseEntity<Map<String, Object>> response = handler.handleValidation(ex);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Map<String, Object> body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.get("status")).isEqualTo(400);
        assertThat(body.get("error")).isEqualTo("Validation Failed");
        assertThat(((Map<?, ?>)body.get("message")).get("field")).isEqualTo("must not be null");
        assertThat(body.get("correlationId")).isNotNull();
    }

    @Test
    void handleAll_returnsInternalServerError() {
        Exception ex = new RuntimeException("Something went wrong");
        ResponseEntity<Map<String, Object>> response = handler.handleAll(ex);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        Map<String, Object> body = response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.get("status")).isEqualTo(500);
        assertThat(body.get("error")).isEqualTo("Internal Server Error");
        assertThat(body.get("message")).isEqualTo("Something went wrong");
        assertThat(body.get("correlationId")).isNotNull();
    }
}

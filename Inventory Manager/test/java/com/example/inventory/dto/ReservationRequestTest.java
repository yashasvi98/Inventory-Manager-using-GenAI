package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class ReservationRequestTest {
    private final Validator validator;
    public ReservationRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validReservationRequest_passesValidation() {
        ReservationRequest req = ReservationRequest.builder()
                .itemId(1L)
                .quantity(2)
                .reservedFor("User")
                .build();
        Set<ConstraintViolation<ReservationRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidReservationRequest_missingFields_failsValidation() {
        ReservationRequest req = new ReservationRequest();
        Set<ConstraintViolation<ReservationRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

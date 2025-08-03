package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;

import static org.assertj.core.api.Assertions.assertThat;

class BatchRequestTest {
    private final Validator validator;

    public BatchRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validBatchRequest_passesValidation() {
        BatchRequest req = BatchRequest.builder()
                .batchNumber("B123")
                .itemId(1L)
                .quantity(10)
                .expiryDate(null)
                .build();
        Set<ConstraintViolation<BatchRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }

    @Test
    void invalidBatchRequest_missingFields_failsValidation() {
        BatchRequest req = new BatchRequest();
        Set<ConstraintViolation<BatchRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

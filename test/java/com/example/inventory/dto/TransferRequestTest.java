package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class TransferRequestTest {
    private final Validator validator;
    public TransferRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validTransferRequest_passesValidation() {
        TransferRequest req = TransferRequest.builder()
                .itemId(1L)
                .quantity(5)
                .sourceLocationId(2L)
                .destinationLocationId(3L)
                .build();
        Set<ConstraintViolation<TransferRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidTransferRequest_missingFields_failsValidation() {
        TransferRequest req = new TransferRequest();
        Set<ConstraintViolation<TransferRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

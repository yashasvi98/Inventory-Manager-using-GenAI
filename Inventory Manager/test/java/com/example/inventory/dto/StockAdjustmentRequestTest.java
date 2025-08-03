package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class StockAdjustmentRequestTest {
    private final Validator validator;
    public StockAdjustmentRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validStockAdjustmentRequest_passesValidation() {
        StockAdjustmentRequest req = StockAdjustmentRequest.builder()
                .itemId(1L)
                .quantityChange(5)
                .reason("Restock")
                .build();
        Set<ConstraintViolation<StockAdjustmentRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidStockAdjustmentRequest_missingFields_failsValidation() {
        StockAdjustmentRequest req = new StockAdjustmentRequest();
        Set<ConstraintViolation<StockAdjustmentRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

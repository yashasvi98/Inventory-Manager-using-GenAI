package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class SupplierRequestTest {
    private final Validator validator;
    public SupplierRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validSupplierRequest_passesValidation() {
        SupplierRequest req = SupplierRequest.builder().name("TestSupplier").build();
        Set<ConstraintViolation<SupplierRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidSupplierRequest_nullName_failsValidation() {
        SupplierRequest req = new SupplierRequest();
        Set<ConstraintViolation<SupplierRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

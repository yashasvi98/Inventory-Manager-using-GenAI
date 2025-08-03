package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class LocationRequestTest {
    private final Validator validator;
    public LocationRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validLocationRequest_passesValidation() {
        LocationRequest req = LocationRequest.builder().name("Loc").type("SHELF").build();
        Set<ConstraintViolation<LocationRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidLocationRequest_missingFields_failsValidation() {
        LocationRequest req = new LocationRequest();
        Set<ConstraintViolation<LocationRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

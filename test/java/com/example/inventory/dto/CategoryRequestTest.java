package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryRequestTest {
    private final Validator validator;
    public CategoryRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validCategoryRequest_passesValidation() {
        CategoryRequest req = CategoryRequest.builder().name("Test").build();
        Set<ConstraintViolation<CategoryRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidCategoryRequest_nullName_failsValidation() {
        CategoryRequest req = new CategoryRequest();
        Set<ConstraintViolation<CategoryRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

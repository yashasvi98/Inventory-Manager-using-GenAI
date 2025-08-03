package com.example.inventory.dto;

import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import static org.assertj.core.api.Assertions.assertThat;

class ItemRequestTest {
    private final Validator validator;
    public ItemRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void validItemRequest_passesValidation() {
        ItemRequest req = ItemRequest.builder().name("TestItem").sku("SKU123").categoryId(1L).build();
        Set<ConstraintViolation<ItemRequest>> violations = validator.validate(req);
        assertThat(violations).isEmpty();
    }
    @Test
    void invalidItemRequest_missingFields_failsValidation() {
        ItemRequest req = new ItemRequest();
        Set<ConstraintViolation<ItemRequest>> violations = validator.validate(req);
        assertThat(violations).isNotEmpty();
    }
}

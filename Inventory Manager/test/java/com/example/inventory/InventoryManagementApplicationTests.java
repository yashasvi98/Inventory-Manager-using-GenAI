package com.example.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryManagementApplicationTests {
    @Test
    void contextLoads() {
        // The test will fail if the application context cannot start
        org.assertj.core.api.Assertions.assertThat(true).isTrue();
    }
}

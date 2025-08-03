package com.example.inventory.mapper;

import com.example.inventory.dto.LowStockAlertResponse;
import com.example.inventory.entity.LowStockAlert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LowStockAlertMapperTest {
    @Test
    void toResponse_mapsAllFields() {
        LowStockAlert entity = LowStockAlert.builder().id(1L).itemId(2L).alertMessage("Low").build();
        LowStockAlertResponse resp = LowStockAlertMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(1L);
        assertThat(resp.getItemId()).isEqualTo(2L);
        assertThat(resp.getAlertMessage()).isEqualTo("Low");
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> LowStockAlertMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

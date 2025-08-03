package com.example.inventory.mapper;

import com.example.inventory.dto.StockAdjustmentRequest;
import com.example.inventory.dto.StockAdjustmentResponse;
import com.example.inventory.entity.StockAdjustment;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StockAdjustmentMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        StockAdjustmentRequest req = StockAdjustmentRequest.builder().itemId(1L).quantityChange(5).reason("Restock").build();
        StockAdjustment s = StockAdjustmentMapper.toEntity(req);
        assertThat(s.getItemId()).isEqualTo(1L);
        assertThat(s.getQuantityChange()).isEqualTo(5);
        assertThat(s.getReason()).isEqualTo("Restock");
    }

    @Test
    void toResponse_mapsAllFields() {
        StockAdjustment entity = StockAdjustment.builder().id(2L).itemId(1L).quantityChange(5).reason("Restock").build();
        StockAdjustmentResponse resp = StockAdjustmentMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getItemId()).isEqualTo(1L);
        assertThat(resp.getQuantityChange()).isEqualTo(5);
        assertThat(resp.getReason()).isEqualTo("Restock");
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> StockAdjustmentMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> StockAdjustmentMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

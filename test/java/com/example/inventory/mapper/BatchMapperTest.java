package com.example.inventory.mapper;

import com.example.inventory.dto.BatchRequest;
import com.example.inventory.dto.BatchResponse;
import com.example.inventory.entity.Batch;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

class BatchMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        BatchRequest req = BatchRequest.builder()
                .itemId(1L)
                .batchNumber("B1")
                .expiryDate(LocalDate.now().plusDays(10))
                .quantity(5)
                .build();
        Batch b = BatchMapper.toEntity(req);
        assertThat(b.getItemId()).isEqualTo(1L);
        assertThat(b.getBatchNumber()).isEqualTo("B1");
        assertThat(b.getExpiryDate()).isEqualTo(req.getExpiryDate());
        assertThat(b.getQuantity()).isEqualTo(5);
    }

    @Test
    void toResponse_mapsAllFields() {
        Batch entity = Batch.builder()
                .id(2L)
                .itemId(1L)
                .batchNumber("B1")
                .expiryDate(LocalDate.now().plusDays(10))
                .quantity(5)
                .build();
        BatchResponse resp = BatchMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getItemId()).isEqualTo(1L);
        assertThat(resp.getBatchNumber()).isEqualTo("B1");
        assertThat(resp.getExpiryDate()).isEqualTo(entity.getExpiryDate());
        assertThat(resp.getQuantity()).isEqualTo(5);
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> BatchMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> BatchMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

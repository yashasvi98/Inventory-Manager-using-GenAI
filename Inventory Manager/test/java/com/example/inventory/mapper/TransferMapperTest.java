package com.example.inventory.mapper;

import com.example.inventory.dto.TransferRequest;
import com.example.inventory.dto.TransferResponse;
import com.example.inventory.entity.Transfer;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TransferMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        TransferRequest req = TransferRequest.builder().itemId(1L).quantity(2).sourceLocationId(3L).destinationLocationId(4L).build();
        Transfer t = TransferMapper.toEntity(req);
        assertThat(t.getItemId()).isEqualTo(1L);
        assertThat(t.getQuantity()).isEqualTo(2);
        assertThat(t.getSourceLocationId()).isEqualTo(3L);
        assertThat(t.getDestinationLocationId()).isEqualTo(4L);
    }

    @Test
    void toResponse_mapsAllFields() {
        Transfer entity = Transfer.builder().id(2L).itemId(1L).quantity(2).sourceLocationId(3L).destinationLocationId(4L).build();
        TransferResponse resp = TransferMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getItemId()).isEqualTo(1L);
        assertThat(resp.getQuantity()).isEqualTo(2);
        assertThat(resp.getSourceLocationId()).isEqualTo(3L);
        assertThat(resp.getDestinationLocationId()).isEqualTo(4L);
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> TransferMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> TransferMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

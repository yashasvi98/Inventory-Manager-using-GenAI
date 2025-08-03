package com.example.inventory.mapper;

import com.example.inventory.dto.SupplierRequest;
import com.example.inventory.dto.SupplierResponse;
import com.example.inventory.entity.Supplier;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SupplierMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        SupplierRequest req = SupplierRequest.builder().name("Supplier1").build();
        Supplier s = SupplierMapper.toEntity(req);
        assertThat(s.getName()).isEqualTo("Supplier1");
    }

    @Test
    void toResponse_mapsAllFields() {
        Supplier entity = Supplier.builder().id(2L).name("Supplier1").build();
        SupplierResponse resp = SupplierMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getName()).isEqualTo("Supplier1");
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> SupplierMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> SupplierMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

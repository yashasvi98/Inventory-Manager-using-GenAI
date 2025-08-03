package com.example.inventory.mapper;

import com.example.inventory.dto.LocationRequest;
import com.example.inventory.dto.LocationResponse;
import com.example.inventory.entity.Location;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LocationMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        LocationRequest req = LocationRequest.builder().name("Loc1").type("SHELF").build();
        Location l = LocationMapper.toEntity(req);
        assertThat(l.getName()).isEqualTo("Loc1");
        assertThat(l.getType()).isEqualTo("SHELF");
    }

    @Test
    void toResponse_mapsAllFields() {
        Location entity = Location.builder().id(2L).name("Loc1").type("SHELF").build();
        LocationResponse resp = LocationMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getName()).isEqualTo("Loc1");
        assertThat(resp.getType()).isEqualTo("SHELF");
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> LocationMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> LocationMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

package com.example.inventory.mapper;

import com.example.inventory.dto.ItemRequest;
import com.example.inventory.dto.ItemResponse;
import com.example.inventory.entity.Item;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ItemMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        ItemRequest req = ItemRequest.builder().name("Item1").sku("SKU1").categoryId(2L).build();
        Item i = ItemMapper.toEntity(req);
        assertThat(i.getName()).isEqualTo("Item1");
        assertThat(i.getSku()).isEqualTo("SKU1");
        assertThat(i.getCategoryId()).isEqualTo(2L);
    }

    @Test
    void toResponse_mapsAllFields() {
        Item entity = Item.builder().id(3L).name("Item1").sku("SKU1").categoryId(2L).build();
        ItemResponse resp = ItemMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(3L);
        assertThat(resp.getName()).isEqualTo("Item1");
        assertThat(resp.getSku()).isEqualTo("SKU1");
        assertThat(resp.getCategoryId()).isEqualTo(2L);
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> ItemMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> ItemMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

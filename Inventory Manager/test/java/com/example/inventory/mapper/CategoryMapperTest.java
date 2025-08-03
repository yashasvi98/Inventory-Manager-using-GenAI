package com.example.inventory.mapper;

import com.example.inventory.dto.CategoryRequest;
import com.example.inventory.dto.CategoryResponse;
import com.example.inventory.entity.Category;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CategoryMapperTest {
    @Test
    void toEntity_mapsAllFields() {
        CategoryRequest req = CategoryRequest.builder().name("Cat1").build();
        Category c = CategoryMapper.toEntity(req);
        assertThat(c.getName()).isEqualTo("Cat1");
    }

    @Test
    void toResponse_mapsAllFields() {
        Category entity = Category.builder().id(2L).name("Cat1").build();
        CategoryResponse resp = CategoryMapper.toResponse(entity);
        assertThat(resp.getId()).isEqualTo(2L);
        assertThat(resp.getName()).isEqualTo("Cat1");
    }

    @Test
    void toEntity_nullRequest_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> CategoryMapper.toEntity(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void toResponse_nullEntity_throwsNPE() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> CategoryMapper.toResponse(null))
                .isInstanceOf(NullPointerException.class);
    }
}

package com.febatis.demo.adapter;

import com.febatis.demo.model.dto.FooRequestDTO;
import com.febatis.demo.model.dto.FooResponseDTO;
import com.febatis.demo.model.entity.Foo;

public class FooAdapter {

    public static Foo toEntity(FooRequestDTO requestDTO) {
        return Foo.builder()
                .name(requestDTO.getName())
                .build();
    }

    public static FooResponseDTO toResponse(Foo entity) {
        return FooResponseDTO.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .build();
    }
}

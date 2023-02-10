package com.febatis.demo.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class FooResponseDTO {
    private UUID uuid;
    private String name;
}
